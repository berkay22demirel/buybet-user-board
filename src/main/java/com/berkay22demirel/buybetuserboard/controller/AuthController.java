package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.controller.request.UserAuthRequest;
import com.berkay22demirel.buybetuserboard.controller.response.Response;
import com.berkay22demirel.buybetuserboard.dto.AuthDto;
import com.berkay22demirel.buybetuserboard.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/1.0/auth")
    public ResponseEntity<Response> auth(@Valid @RequestBody UserAuthRequest request) {
        AuthDto authDto = authService.auth(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new Response(authDto));
    }
}