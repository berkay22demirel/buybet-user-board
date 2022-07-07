package com.berkay22demirel.buybetuserboard.dto;

import lombok.Data;

@Data
public class AuthDto {

    private String token;
    private UserDto user;
}
