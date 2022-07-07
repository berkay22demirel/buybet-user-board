package com.berkay22demirel.buybetuserboard.service.impl;

import com.berkay22demirel.buybetuserboard.config.TokenConfiguration;
import com.berkay22demirel.buybetuserboard.dto.AuthDto;
import com.berkay22demirel.buybetuserboard.dto.TokenSubjectDto;
import com.berkay22demirel.buybetuserboard.dto.UserDto;
import com.berkay22demirel.buybetuserboard.exception.BuybetAuthException;
import com.berkay22demirel.buybetuserboard.exception.BuybetExpiredAuthException;
import com.berkay22demirel.buybetuserboard.model.User;
import com.berkay22demirel.buybetuserboard.service.AuthService;
import com.berkay22demirel.buybetuserboard.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final TokenConfiguration tokenConfiguration;

    @Override
    public AuthDto auth(String username, String password) {
        User user = userService.getByUsername(username).orElseThrow(() -> new BuybetAuthException("buybet.auth.exception"));
        try {
            if (passwordEncoder.matches(password, user.getPassword())) {
                AuthDto authDto = new AuthDto();
                authDto.setUser(new UserDto(user));
                authDto.setToken(Jwts.builder()
                        .setSubject(new ObjectMapper()
                                .writer()
                                .withDefaultPrettyPrinter()
                                .writeValueAsString(new TokenSubjectDto(user)))
                        .signWith(SignatureAlgorithm.HS512, tokenConfiguration.getTokenSecret())
                        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                        .compact());
                return authDto;
            }
        } catch (Exception e) {
            throw new BuybetAuthException("buybet.auth.exception");
        }
        throw new BuybetAuthException("buybet.auth.exception");
    }

    @Override
    public UserDetails getUserDetails(String token) {
        JwtParser parser = Jwts.parser().setSigningKey(tokenConfiguration.getTokenSecret());
        try {
            parser.parse(token);
            Claims claims = parser.parseClaimsJws(token).getBody();
            TokenSubjectDto tokenDto = new ObjectMapper().readValue(claims.getSubject(), TokenSubjectDto.class);
            return userService.getByUsername(tokenDto.getUsername()).orElseThrow(() -> new BuybetAuthException("buybet.auth.exception"));
        } catch (ExpiredJwtException e) {
            throw new BuybetExpiredAuthException("buybet.auth.expired");
        } catch (Exception e) {
            throw new BuybetAuthException("buybet.auth.exception");
        }
    }

}
