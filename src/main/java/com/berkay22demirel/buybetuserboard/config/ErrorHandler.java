package com.berkay22demirel.buybetuserboard.config;

import com.berkay22demirel.buybetuserboard.controller.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ErrorHandler implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ResponseEntity<Response> handleError(WebRequest webRequest) {
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.values()));
        int status = (Integer) errorAttributes.get("status");
        Response response = new Response((String) errorAttributes.get("message"), getErrors(errorAttributes));
        return ResponseEntity.status(status).body(response);
    }

    private Map<String, String> getErrors(Map<String, Object> errorAttributes) {
        if (errorAttributes.containsKey("errors")) {
            List<FieldError> fieldErrorList = (List<FieldError>) errorAttributes.get("errors");
            return fieldErrorList.stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        }
        return null;
    }

}
