package com.roky.thunderspi.repositories;

import com.roky.thunderspi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo  extends JpaRepository<Comment,Long> {
}
