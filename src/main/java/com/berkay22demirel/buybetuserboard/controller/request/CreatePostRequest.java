package com.berkay22demirel.buybetuserboard.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreatePostRequest {

    @NotNull
    @Size(min = 1, max = 210)
    private String content;
}
