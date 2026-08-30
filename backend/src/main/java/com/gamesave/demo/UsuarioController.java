package com.gamesave.demo;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.databind.deser.bean.BeanAsArrayBuilderDeserializer;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final JdbcTemplate jdbcTemplate;

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Verificar se usuario existe
    @GetMapping({ "/{idUsuario}" })
    public ResponseEntity<Usuario> verificarUsuarioID(@PathVariable Integer idUsuario) {
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";

        try {
            Usuario usuario = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Usuario.class), idUsuario);
            return ResponseEntity.status(200).body(usuario);

        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(404).build();
        }

    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> verificarUsuario(@RequestBody Usuario usuarioAtual) {
        String sql = "SELECT * FROM usuario WHERE email = ? and senha = ?";

        try {
            if (usuarioAtual.getEmail() != null && usuarioAtual.getSenha() != null) {
                Usuario usuario = jdbcTemplate.queryForObject(sql,
                        new BeanPropertyRowMapper<>(Usuario.class), usuarioAtual.getEmail(), usuarioAtual.getSenha());
                usuario.setSenha(null);
                return ResponseEntity.status(200).body(usuario);
            } else {
                return ResponseEntity.status(400).build();
            }

        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(404).build();
        }

    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuarioAtual) {
        try {
            if (usuarioAtual.getEmail() != null && usuarioAtual.getSenha() != null) {

                String sql = "INSERT INTO usuario(nameTag, email, senha) VALUES (?, ?, ?);";

                KeyHolder keyHolder = new GeneratedKeyHolder();

                jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(
                            sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, usuarioAtual.getNameTag());
                    ps.setString(2, usuarioAtual.getEmail());
                    ps.setString(3, usuarioAtual.getSenha());

                    return ps;
                }, keyHolder);
                Number idGerado = (Number) keyHolder.getKey();
                usuarioAtual.setIdUsuario(idGerado.intValue());
                return ResponseEntity.status(201).body(usuarioAtual);
            }else{
                return ResponseEntity.status(400).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }

    // Cadastrar usuario

}
