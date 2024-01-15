package pt.iade.getmatch.dto.request;

public class UserRequest {

    private String emaill;
    private String pass;

    public UserRequest(String emaill, String pass) {
        this.emaill = emaill;
        this.pass = pass;
    }

    public void User() {

    }

    public String getEmail() {
        return emaill;
    }

    public void setEmail(String email) {
        this.emaill = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
