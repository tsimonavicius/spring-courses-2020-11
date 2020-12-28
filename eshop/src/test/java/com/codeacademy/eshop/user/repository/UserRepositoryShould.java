package com.codeacademy.eshop.user.repository;

import com.codeacademy.eshop.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryShould {

    private static final String USER_NAME = "UserName";
    public static final String PASSWORD = "password";

    @Autowired
    private TestEntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Test
    void returnUserByUserName() {
        // given
        User user = new User();
        user.setUsername(USER_NAME);
        user.setPassword(PASSWORD);
        em.persistAndFlush(user);

        // when
        Optional<User> userOptional = userRepository.findByUsername(USER_NAME);

        // then
        assertTrue(userOptional.isPresent());
    }
}
