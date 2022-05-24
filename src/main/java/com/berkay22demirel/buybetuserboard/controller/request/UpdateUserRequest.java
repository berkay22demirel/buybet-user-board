package com.berkay22demirel.buybetuserboard.controller.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateUserRequest {

    @NotNull
    @Size(min = 5, max = 50)
    @Email
    private String email;
    private String image;
}
