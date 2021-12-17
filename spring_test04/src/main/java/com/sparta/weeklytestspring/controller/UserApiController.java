package com.sparta.weeklytestspring.controller;

import com.sparta.weeklytestspring.dto.JwtResponse;
import com.sparta.weeklytestspring.dto.UserRequestDto;
import com.sparta.weeklytestspring.service.UserService;
import com.sparta.weeklytestspring.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequestDto userRequestDto) throws Exception {
        if (userRequestDto.getLoginCheck().equals("signup")) {
            userService.registerUser(userRequestDto); // 사용자 등록
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userRequestDto.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername()));
    }

}
