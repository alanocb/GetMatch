package pt.iade.getmatch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private long id;

    @Column(name = "usr_name")
    private String name;

    @Column(name = "usr_telefone")
    private int telefone;

    @Column(name = "usr_data_nasc")
    private LocalDate bDate;

    @Column(name = "usr_email")
    private String email;

    @Column(name = "usr_senha")
    private String pass;

    public User(long id, String name, int telefone, LocalDate bDate, String emaill, String pass) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.bDate = bDate;
        this.email = emaill;
        this.pass = pass;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emaill) {
        this.email = emaill;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
