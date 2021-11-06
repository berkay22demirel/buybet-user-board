package com.berkay22demirel.buybetuserboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BuybetUserBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuybetUserBoardApplication.class, args);
	}

}
