package com.roky.thunderspi.repositories;

import com.roky.thunderspi.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepo  extends JpaRepository<BlogPost,Long> {
}
