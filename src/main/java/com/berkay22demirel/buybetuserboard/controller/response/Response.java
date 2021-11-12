package com.berkay22demirel.buybetuserboard.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Response {

    private String status;
    private String errorCode;
    private String errorMessage;
    private String locale;
    private long systemTime = new Date().getTime();

    public Response(String status) {
        this.status = status;
    }
}
