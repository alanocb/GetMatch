package pt.iade.getmatch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "jogo")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Jogo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jogo_id")
    private int id;

    /*@Column(name = "usr_id")
    private String userId;*/

    /*@Column(name = "modalidade_jogo_id")
    private String modalidadeJogoId;*/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usr_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modalidade_jogo_id", nullable = false)
    private Modalidade modalidade;

    public Jogo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }*/

    /*public String getModalidadeJogoId() {
        return modalidadeJogoId;
    }

    public void setModalidadeJogoId(String modalidadeJogoId) {
        this.modalidadeJogoId = modalidadeJogoId;
    }*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
