package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserRequestDto;
import com.example.springbootjpa.domain.dto.UserResponseDto;
import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return new UserResponseDto(id, "", "해당 id로 등록된 유저가 없습니다.");
        } else {
            User user = optionalUser.get();
            return new UserResponseDto(user.getId(), user.getUsername(), "");
        }
    }

    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = userRequestDto.toEntity();

        Optional<User> selectedUser = userRepository.findUserByUsername(userRequestDto.getUsername());
        if (selectedUser.isEmpty()) {
            User savedUser = userRepository.save(user);
            return new UserResponseDto(savedUser.getId(), savedUser.getUsername(), "가입이 완료되었습니다.");
        } else {
            return new UserResponseDto(null, userRequestDto.getUsername(), "이미 등록된 username 입니다. 다른 이름으로 등록해주세요.");
        }
    }
}