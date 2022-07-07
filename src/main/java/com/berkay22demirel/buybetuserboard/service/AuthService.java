package com.berkay22demirel.buybetuserboard.service;

import com.berkay22demirel.buybetuserboard.dto.AuthDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

    AuthDto auth(String username, String password);

    UserDetails getUserDetails(String token);
}
