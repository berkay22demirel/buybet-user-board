package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.annotations.CurrentUser;
import com.berkay22demirel.buybetuserboard.controller.dto.UserDto;
import com.berkay22demirel.buybetuserboard.controller.response.Response;
import com.berkay22demirel.buybetuserboard.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/api/1.0/auth")
    public ResponseEntity<Response> auth(@CurrentUser User user) {
        return ResponseEntity.ok(new Response(new UserDto(user)));
    }
}