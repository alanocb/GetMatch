package pt.iade.getmatch.dto.request;

import java.util.List;

public class JogoRequest {

    private int idUser;
    private int idModalidade;

    private int tipoCampo;
    private List<Integer> participantes;

    public JogoRequest() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(int idModalidade) {
        this.idModalidade = idModalidade;
    }

    public int getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(int tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public List<Integer> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Integer> participantes) {
        this.participantes = participantes;
    }
}
