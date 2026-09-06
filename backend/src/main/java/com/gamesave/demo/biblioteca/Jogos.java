package com.gamesave.demo.biblioteca;

import java.util.Date;
import java.util.UUID;

public class Jogos {

    private Integer idJogos;
    private Integer idUsuario;
    private String titulo;
    private Integer horasJogadas;
    private Date dataConclusao;
    private String plataforma;
    private String midia;
    private String statuss;
    private Integer nota;
    private Boolean favorito;
    private String genero;
    private String imagem;


    public Jogos() {
    }

    public Jogos(Integer idJogos, Integer idUsuario, String titulo, Integer horasJogadas, Date dataConclusao, String plataforma, String midia, String statuss, Integer nota, Boolean favorito, String genero, String imagem
    ) {
        this.idJogos = idJogos;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.horasJogadas = horasJogadas;
        this.dataConclusao = dataConclusao;
        this.plataforma = plataforma;
        this.midia = midia;
        this.statuss = statuss;
        this.nota = nota;
        this.favorito = favorito;
        this.genero = genero;
        this.imagem = imagem;
    }

    public Integer getIdJogos() {
        return idJogos;
    }

    public void setId(Integer idJogos) {
        this.idJogos = idJogos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getHorasJogadas() {
        return horasJogadas;
    }

    public void setHorasJogadas(Integer horasJogadas) {
        this.horasJogadas = horasJogadas;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConlusao) {
        this.dataConclusao = dataConlusao;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdJogos(int idJogos) {
        this.idJogos = idJogos;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
