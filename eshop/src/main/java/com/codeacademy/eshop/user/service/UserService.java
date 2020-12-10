package com.codeacademy.eshop.user.service;

import com.codeacademy.eshop.user.exception.UserNotFoundException;
import com.codeacademy.eshop.user.model.User;
import com.codeacademy.eshop.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

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

    public void updateUser(Long id, User newUser) {
        User existingUser = getUserById(id);
        // FIXME: Use mapper or BeanUtil.
        existingUser.setPhone(newUser.getPhone());
        existingUser.setPhone(newUser.getZip());
        userRepository.save(existingUser);
    }

    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
