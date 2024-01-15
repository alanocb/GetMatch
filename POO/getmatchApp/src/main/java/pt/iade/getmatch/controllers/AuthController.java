package pt.iade.getmatch.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.getmatch.Repository.UserRepository;
import pt.iade.getmatch.dto.ErrorResponse;
import pt.iade.getmatch.dto.Response.UserAuthResponse;
import pt.iade.getmatch.dto.Response.UserResponse;
import pt.iade.getmatch.models.User;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody User userRequest) {
        var emaill = userRequest.getEmail();
        var pass = userRequest.getPass();

        var user = this.userRepository.findByEmail(emaill);
        if (!user.isPresent()) {
            var errorResponse = new ErrorResponse();
            errorResponse.setStatus(400);
            errorResponse.setMessage("Email não registrado, tente criar uma conta!");
            return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
        }

        if (!(user.get().getPass().equals(pass))) {
            var errorResponse = new ErrorResponse();
            errorResponse.setStatus(400);
            errorResponse.setMessage("Email/Senha errada");
            return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
        }

        var userAuthResponse = new UserAuthResponse(
                user.get().getEmail(),
                user.get().getPass()
        );

        var userResponse = new UserResponse();
        userResponse.setId(user.get().getId());
        userResponse.setEmaill(user.get().getEmail());
        userResponse.setPass(user.get().getPass());

        userAuthResponse.setUserData(userResponse);

        return ResponseEntity.ok().body(userAuthResponse);

    }

}
