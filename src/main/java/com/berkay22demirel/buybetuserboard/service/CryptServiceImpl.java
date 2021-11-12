package com.berkay22demirel.buybetuserboard.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptServiceImpl implements CryptService {

    private final PasswordEncoder passwordEncoder;

    public CryptServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(String value) {
        return passwordEncoder.encode(value);
    }
}
