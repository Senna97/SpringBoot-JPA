package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserRequestDto;
import com.example.springbootjpa.domain.dto.UserResponseDto;
import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.respository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {
    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository); // 수동 DI
    }

    @Test
    @DisplayName("회원 등록 성공 메세지 출력")
    void addTest() {
        Mockito.when(userRepository.save(any()))
                .thenReturn(Optional.of(new User(1L, "seohyeon", "1234")));
        UserResponseDto userResponseDto = userService.addUser(new UserRequestDto("seohyeon", "1234"));
        assertEquals("가입이 완료되었습니다.", userResponseDto.getMessage());
    }
}