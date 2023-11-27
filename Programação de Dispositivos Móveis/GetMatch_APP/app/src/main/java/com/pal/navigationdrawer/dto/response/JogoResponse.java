package com.pal.navigationdrawer.dto.response;

public class JogoResponse {
    private int id;
    private UserResponse user;
    private ModalidadeResponse modalidade;

    public JogoResponse() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public ModalidadeResponse getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeResponse modalidade) {
        this.modalidade = modalidade;
    }
}
