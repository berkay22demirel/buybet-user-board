package com.berkay22demirel.buybetuserboard.service;

import com.berkay22demirel.buybetuserboard.model.User;
import com.berkay22demirel.buybetuserboard.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CryptService cryptService;

    public UserServiceImpl(UserRepository userRepository, CryptService cryptService) {
        this.userRepository = userRepository;
        this.cryptService = cryptService;
    }

    @Override
    public void create(User user) {
        user.setPassword(cryptService.encode(user.getPassword()));
        userRepository.save(user);
    }
}
