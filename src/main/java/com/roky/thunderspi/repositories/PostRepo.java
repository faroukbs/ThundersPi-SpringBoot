package com.roky.thunderspi.repositories;


import com.roky.thunderspi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo  extends JpaRepository<Post,Long> {
}
