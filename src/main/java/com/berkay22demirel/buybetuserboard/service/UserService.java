package com.berkay22demirel.buybetuserboard.service;

import com.berkay22demirel.buybetuserboard.model.User;

import java.util.Optional;

public interface UserService {

    void create(User user);

    Optional<User> getByUsername(String username);

    void updateUser(String username, String email, String image);
}
