package com.sparta.weeklytestspring.service;

import com.sparta.weeklytestspring.domain.User;
import com.sparta.weeklytestspring.dto.UserRequestDto;
import com.sparta.weeklytestspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void registerUser(UserRequestDto userRequestDto) {
        String username = userRequestDto.getUsername();

        // 비밀번호 인코딩
        String password = passwordEncoder.encode(userRequestDto.getPassword());

        User user = new User(username, password);
        userRepository.save(user);
    }
}
