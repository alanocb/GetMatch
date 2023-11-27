package com.pal.navigationdrawer.dto.response;

public class ModalidadeResponse {
    private int id;
    private String name;
    private String tipo;
    private int nmrJogadores;

    public ModalidadeResponse() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNmrJogadores() {
        return nmrJogadores;
    }

    public void setNmrJogadores(int nmrJogadores) {
        this.nmrJogadores = nmrJogadores;
    }
}
