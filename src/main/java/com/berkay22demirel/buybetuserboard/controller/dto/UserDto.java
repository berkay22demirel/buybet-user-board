package com.berkay22demirel.buybetuserboard.controller.dto;

import com.berkay22demirel.buybetuserboard.model.User;
import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String email;
    private String phone;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }
}
