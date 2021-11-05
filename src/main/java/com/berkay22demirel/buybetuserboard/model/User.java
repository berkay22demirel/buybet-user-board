package com.berkay22demirel.buybetuserboard.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private String username;
    private String email;
    private String phone;
    private String password;
}
