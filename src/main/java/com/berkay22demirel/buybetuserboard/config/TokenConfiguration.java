package com.berkay22demirel.buybetuserboard.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class TokenConfiguration {

    @Value("${security.token.secret}")
    private String tokenSecret;
}
