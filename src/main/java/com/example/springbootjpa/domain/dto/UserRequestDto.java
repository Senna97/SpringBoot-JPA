package com.example.springbootjpa.domain.dto;


import com.example.springbootjpa.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    Long id;
    String username;
    String password;

    public UserRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}
