package com.berkay22demirel.buybetuserboard.controller.response;

import com.berkay22demirel.buybetuserboard.constant.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String status;
    private String errorMessage;
    private Map<String, String> validationErrors;
    private Object data;
    private long systemTime = new Date().getTime();

    public Response(String errorMessage) {
        this.errorMessage = errorMessage;
        this.status = ResponseStatus.FAILURE.getValue();
    }

    public Response(String errorMessage, Map<String, String> validationErrors) {
        this.errorMessage = errorMessage;
        this.validationErrors = validationErrors;
        this.status = ResponseStatus.FAILURE.getValue();
    }


    public Response(Object data) {
        this.data = data;
        this.status = ResponseStatus.SUCCESS.getValue();
    }

    public Response(ResponseStatus responseStatus) {
        this.status = responseStatus.getValue();
    }

}
