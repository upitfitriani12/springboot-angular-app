package com.upit.controller;

import com.upit.model.User;
import com.upit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception {

        User isExist = userRepository.findByEmail(user.getEmail());
        if(isExist != null){
            throw new Exception("user is exist with " + user.getEmail());
        }

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) throws Exception {
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception {
        List<User> users = userRepository.findAll();
        return users;
    }

}
