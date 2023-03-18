package com.roky.thunderspi.repositories;

import com.roky.thunderspi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
