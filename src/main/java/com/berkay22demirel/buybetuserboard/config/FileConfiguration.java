package com.berkay22demirel.buybetuserboard.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class FileConfiguration {

    @Value("${file.user.profile-image-path}")
    private String userProfileImagePath;
}
