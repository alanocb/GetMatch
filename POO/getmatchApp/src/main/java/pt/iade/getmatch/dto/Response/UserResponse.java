package pt.iade.getmatch.dto.Response;

public class UserResponse {


    private Long id;
    private String emaill;
    private String pass;

    public UserResponse(Long id, String emaill, String pass) {
        this.id = id;
        this.emaill = emaill;
        this.pass = pass;

    }

    public UserResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
