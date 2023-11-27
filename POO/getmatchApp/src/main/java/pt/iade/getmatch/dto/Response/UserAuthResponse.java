package pt.iade.getmatch.dto.Response;

public class UserAuthResponse extends AuthResponse {

    private UserResponse UserData;

    public UserAuthResponse(String emaill, String pass) {
        super(emaill, pass);
    }

    public UserResponse UserData() {

        return UserData;
    }

    public void setUserData(UserResponse userData) {

        this.UserData = userData;
    }
}
