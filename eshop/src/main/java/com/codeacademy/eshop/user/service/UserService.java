package com.codeacademy.eshop.user.service;

import com.codeacademy.eshop.user.exception.UserNotFoundException;
import com.codeacademy.eshop.user.model.User;
import com.codeacademy.eshop.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves new user in the database
     */
    public User addUser(User user) {
        // TODO: user password encoder here...
        UUID tempPsw = UUID.randomUUID();
        user.setPassword(tempPsw.toString());
        return userRepository.save(user);
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
