package com.mustache.springbootmustachebbs.user_exercise.service;

import com.mustache.springbootmustachebbs.user_exercise.domain.dto.UserAddRequest;
import com.mustache.springbootmustachebbs.user_exercise.domain.dto.UserResponse;
import com.mustache.springbootmustachebbs.user_exercise.domain.entity.User;
import com.mustache.springbootmustachebbs.user_exercise.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

// @SpringBootTest 를 안 써줌으로서 속도 증가
class UserServiceTest {

    // Spring을 통해서 DI 하는 것이 아닌 Mockito를 통해서 UserRepository를 DI
    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private UserService userService;

    @BeforeEach
    void setUp() {
        // Spring을 사용하지 않기 때문에 수동으로 DI 진행
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("Add User Test")
    void addTest() {

        Mockito.when(userRepository.save(any()))
                .thenReturn(new User(1L, "user123", "123123"));

        UserResponse userResponse = userService.addUser(new UserAddRequest("user123", "123123"));
        assertEquals("가입이 완료 되었습니다.", userResponse.getMessage());
        assertEquals("user123", userResponse.getUsername());
    }
}