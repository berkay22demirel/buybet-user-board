package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.constant.ResponseStatus;
import com.berkay22demirel.buybetuserboard.controller.dto.UserDto;
import com.berkay22demirel.buybetuserboard.controller.request.UpdateUserRequest;
import com.berkay22demirel.buybetuserboard.controller.response.Response;
import com.berkay22demirel.buybetuserboard.exception.BuybetNotFoundException;
import com.berkay22demirel.buybetuserboard.model.User;
import com.berkay22demirel.buybetuserboard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/1.0/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> signup(@Valid @RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok(new Response(ResponseStatus.SUCCESS));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Response> getUser(@PathVariable String username) {
        return userService.getByUsername(username)
                .map(user -> ResponseEntity.ok(new Response(new UserDto(user))))
                .orElseThrow(() -> new BuybetNotFoundException("buybet.user.notFound"));
    }

    @PutMapping("{username}")
    public ResponseEntity<Response> updateUser(@PathVariable String username, @Valid @RequestBody UpdateUserRequest request) {
        User user = userService.updateUser(username, request.getEmail(), request.getImage());
        return ResponseEntity.ok(new Response(new UserDto(user)));
    }

}
