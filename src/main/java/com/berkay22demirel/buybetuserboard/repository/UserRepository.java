package com.berkay22demirel.buybetuserboard.repository;

import com.berkay22demirel.buybetuserboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
