package com.upit.service;

import com.upit.config.JwtProvider;
import com.upit.model.User;
import com.upit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws Exception {
        return userRepository.findById(userId)
                .orElseThrow(() -> new Exception("user not found with id " + userId));
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);

        if (email == null) {
            throw new Exception("provide valid jwt token...");
        }
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new Exception("user not found with email " + email);
        }
        return user;
    }
}
