package com.matrosov;

import com.matrosov.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parametrresolver.UserResolver;

@ExtendWith(UserResolver.class)
public class UserTest {

    @Test
    void firstParameterResolverTest(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username + " : " + password);
    }
}
