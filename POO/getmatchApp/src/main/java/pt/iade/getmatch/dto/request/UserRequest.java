package pt.iade.getmatch.dto.request;

public class UserRequest {

    private String email;
    private String pass;

    public UserRequest(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public void User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
