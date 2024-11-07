package com.matrosov;

import com.matrosov.dao.UserDao;
import com.matrosov.entity.User;
import com.matrosov.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private final User MEN = User.builder().id(1).username("bunny").password("908").build();
    private UserDao userDao;
    private UserService userService;

    @BeforeEach
    void init() {
        userDao = mock(UserDao.class);
        userService = new UserService(userDao);
    }

    @Test
    void findAllAccess() {

        when(userDao.findAll())
                .thenReturn(asList(User.builder().id(1).build(), User.builder().id(2).build()));

        List<User> all = userService.findAll();
        assertAll(
                () -> assertEquals(1, all.get(0).getId()),
                () -> assertEquals(2, all.get(1).getId())
        );
    }

    @Test
    void saveAccess() {
        userService.updateUser(MEN);

        verify(userDao, times(1)).save(any(User.class));
    }

}
