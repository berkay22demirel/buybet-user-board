package com.berkay22demirel.buybetuserboard.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final FileConfiguration fileConfiguration;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:./" + fileConfiguration.getUserProfileImagePath() + "/")
                .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
    }

    @Bean
    public CommandLineRunner initFolders() {
        return (args -> {
            File profilePictureFolder = new File(fileConfiguration.getUserProfileImagePath());
            if (!profilePictureFolder.exists() || profilePictureFolder.isDirectory()) {
                profilePictureFolder.mkdir();
            }
        });
    }
}
