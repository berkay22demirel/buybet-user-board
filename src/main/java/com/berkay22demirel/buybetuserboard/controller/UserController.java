package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/1.0/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public void signup(@RequestBody User user) {
        logger.info(user.toString());

    }
}
