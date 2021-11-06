package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.model.User;
import com.berkay22demirel.buybetuserboard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/1.0/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void signup(@RequestBody User user) {
        logger.info(user.toString());
        userService.create(user);
    }
}
