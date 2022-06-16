package com.berkay22demirel.buybetuserboard.repository;

import com.berkay22demirel.buybetuserboard.model.Post;
import com.berkay22demirel.buybetuserboard.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUser(User user, Pageable pageable);

    Page<Post> findByIdLessThan(long id, Pageable pageable);

    List<Post> findByIdGreaterThan(long id, Sort sort);

    Page<Post> findByUserAndIdLessThan(User user, long id, Pageable pageable);

    List<Post> findByUserAndIdGreaterThan(User user, long id, Sort sort);
}
