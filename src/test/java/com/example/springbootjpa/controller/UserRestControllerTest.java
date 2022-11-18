package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dto.UserResponseDto;
import com.example.springbootjpa.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("Id로 User 조회 기능")
    void findById() throws Exception {
        given(userService.getUser(1L)).willReturn(new UserResponseDto(1L, "seohyeon", ""));

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andDo(print());
    }

    @Test
    @DisplayName("Id로 User 조회 기능: 실패 시 message 출력")
    void findByIdFail() throws Exception {
        given(userService.getUser(2L)).willReturn(new UserResponseDto(null, "seohyeon", "해당 id로 등록된 유저가 없습니다."));

        mockMvc.perform(get("/api/v1/users/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isEmpty())
                .andExpect(jsonPath("$.message").value("해당 id로 등록된 유저가 없습니다."))
                .andDo(print());
    }
}