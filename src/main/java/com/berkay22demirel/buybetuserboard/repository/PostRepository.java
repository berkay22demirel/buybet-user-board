package com.berkay22demirel.buybetuserboard.repository;

import com.berkay22demirel.buybetuserboard.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
