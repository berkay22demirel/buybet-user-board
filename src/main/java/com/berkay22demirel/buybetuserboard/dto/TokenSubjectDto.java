package com.berkay22demirel.buybetuserboard.dto;

import com.berkay22demirel.buybetuserboard.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TokenSubjectDto {

    private String username;
    private List<String> authorities;

    public TokenSubjectDto(User user) {
        this.username = user.getUsername();
        this.authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    public TokenSubjectDto() {
    }
}
