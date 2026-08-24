package com.gamesave.save;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();


    // Verificar se usuario existe
    @GetMapping
    public ResponseEntity<List<Usuario>> verificarUsuario(){
        String sql = "SELECT * FROM usuario Where email = ? AND senha = ?";
        
    }

    // Cadastrar usuario

    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        if()
    }

}
