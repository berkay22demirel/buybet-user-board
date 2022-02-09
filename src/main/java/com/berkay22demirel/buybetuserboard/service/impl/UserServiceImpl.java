package com.berkay22demirel.buybetuserboard.service.impl;

import com.berkay22demirel.buybetuserboard.exception.BuybetNotFoundException;
import com.berkay22demirel.buybetuserboard.model.User;
import com.berkay22demirel.buybetuserboard.repository.UserRepository;
import com.berkay22demirel.buybetuserboard.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void updateUser(String username, String email, String image) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BuybetNotFoundException("buybet.user.notFound"));
        user.setEmail(email);
        user.setImage(image);
        userRepository.save(user);
    }
}
