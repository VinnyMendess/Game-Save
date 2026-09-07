package com.gamesave.demo.biblioteca;

import com.gamesave.demo.Usuario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jogos")
public class JogosController {

    private final JdbcTemplate jdbcTemplate;

    private List<Jogos> jogos = new ArrayList<>();

    public JogosController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Cadastrar jogo
    @PostMapping("/cadastrar")
    public ResponseEntity<Jogos> cadastrarJogo(@RequestBody Jogos jogos) {
        try {
            if (jogos.getTitulo() == null || jogos.getTitulo().isBlank()) {
                return ResponseEntity.status(400).build();
            }
            if (jogos.getNota() != null && (jogos.getNota() < 0 || jogos.getNota() > 10)) {
                return ResponseEntity.status(400).build();
            }
            if (jogos.getMidia() != null) {
                String midiaStr = jogos.getMidia().toLowerCase();
                if (!midiaStr.equalsIgnoreCase("físico") && !midiaStr.equalsIgnoreCase("digital")) {
                    return ResponseEntity.status(400).build();
                }
            }

            String sql = "INSERT INTO bibliotecaJogo (idUsuario, titulo, horasJogadas, dataConclusao, plataforma, midia, statuss, nota, favorito, genero, imagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, jogos.getIdUsuario());
                ps.setString(2, jogos.getTitulo());

                if (jogos.getHorasJogadas() != null) {
                    ps.setInt(3, jogos.getHorasJogadas());
                } else {
                    ps.setNull(3, java.sql.Types.INTEGER);
                }

                if (jogos.getDataConclusao() != null) {
                    ps.setDate(4, new java.sql.Date(jogos.getDataConclusao().getTime()));
                } else {
                    ps.setNull(4, java.sql.Types.DATE);
                }

                ps.setString(5, jogos.getPlataforma());

                if (jogos.getMidia() != null) {
                    ps.setString(6, jogos.getMidia());
                } else {
                    ps.setNull(6, java.sql.Types.VARCHAR);
                }

                ps.setString(7, jogos.getStatuss());

                if (jogos.getNota() != null) {
                    ps.setInt(8, jogos.getNota());
                } else {
                    ps.setNull(8, java.sql.Types.INTEGER);
                }

                if (jogos.getFavorito() != null) {
                    ps.setBoolean(9, jogos.getFavorito());
                } else {
                    ps.setNull(9, java.sql.Types.BOOLEAN);
                }



                ps.setString(10, jogos.getGenero());
                ps.setString(11, jogos.getImagem());
                return ps;
            }, keyHolder);

            Number idGerado = (Number) keyHolder.getKey();
            if (idGerado != null) {
                jogos.setIdJogos(idGerado.intValue());
            }

            return ResponseEntity.status(201).body(jogos);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }

    // Listar jogos por usuário
    @GetMapping("/listar/{idUsuario}")
    public ResponseEntity<List<Jogos>> listarjogos(@PathVariable Integer idUsuario){
        String sql = "SELECT * FROM bibliotecaJogo WHERE idUsuario = ?";

        try {
            List<Jogos> listaJogos = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Jogos.class), idUsuario);
            return ResponseEntity.status(200).body(listaJogos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/status")
    public ResponseEntity<List<String>> listarStatus(){
        List<String> statusList = List.of("Jogando", "Concluído", "Lista de Desejos", "Pausado");
        return ResponseEntity.status(200).body(statusList);
    }
}