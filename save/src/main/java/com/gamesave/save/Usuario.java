package com.gamesave.save;

public class Usuario {
    
    private Integer idUsuario;
    private String nameTag;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nameTag, String email, String senha) {
        this.idUsuario = idUsuario;
        this.nameTag = nameTag;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
