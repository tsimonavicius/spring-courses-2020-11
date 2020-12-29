package com.codeacademy.eshop.user.repository;

import com.codeacademy.eshop.user.model.Role;
import com.codeacademy.eshop.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class UserRepositoryShould {

    private static final String USER_NAME = "UserName";
    private static final String PASSWORD = "password";
    private static final String ROLE_NAME = "NAUJA_ROLE";

    @Autowired
    private TestEntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Test
    void returnUserWithRolesByUserName() {
        // given
        User user = new User();
        user.setUsername(USER_NAME);
        user.setPassword(PASSWORD);
        user.setRoles(Set.of(Role.builder().roleName(ROLE_NAME).build()));
        em.persistAndFlush(user);

        // when
        Optional<User> userOptional = userRepository.findWithRolesByUsername(USER_NAME);

        // then
        assertTrue(userOptional.isPresent());
        assertThat(userOptional.get().getRoles(),
                containsInAnyOrder(
                    hasProperty("roleName", equalTo(ROLE_NAME))));
    }
}
