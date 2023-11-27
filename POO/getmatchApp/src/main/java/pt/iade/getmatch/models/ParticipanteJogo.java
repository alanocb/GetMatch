package pt.iade.getmatch.models;

import jakarta.persistence.*;

@Entity
@Table(name = "participante_jogo")
public class ParticipanteJogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participante_jogo_id")
    private int id;

    @Column(name = "usr_id")
    private int userId;

    @Column(name = "jogo_id")
    private int jogoId;

    @Column(name = "estado_participante_jogo_id")
    private int estadoParticipanteJogoId = 3;

    public ParticipanteJogo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getJogoId() {
        return jogoId;
    }

    public void setJogoId(int jogoId) {
        this.jogoId = jogoId;
    }

    public int getEstadoParticipanteJogoId() {
        return estadoParticipanteJogoId;
    }

    public void setEstadoParticipanteJogoId(int estadoParticipanteJogoId) {
        this.estadoParticipanteJogoId = estadoParticipanteJogoId;
    }
}
