package com.sparta.weeklytestspring.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
    String username;
    String password;
    String loginCheck;
}
