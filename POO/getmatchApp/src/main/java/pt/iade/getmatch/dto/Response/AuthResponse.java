package pt.iade.getmatch.dto.Response;

public class AuthResponse {

    private String emaill;
    private String pass;

    public AuthResponse(String emaill, String pass) {
        this.emaill = emaill;
        this.pass = pass;
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
