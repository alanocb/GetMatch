package pt.iade.getmatch.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.getmatch.Repository.UserRepository;
import pt.iade.getmatch.models.User;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private UserRepository userRepository;

    public void UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getStudents() {

        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> getStudent(@PathVariable("id") int id) {

        return userRepository.findById(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public User savUser(@RequestBody User user) {

        return userRepository.save(user);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable("id") int id) {

        userRepository.deleteById(id);
    }

}
