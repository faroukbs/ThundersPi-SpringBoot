package com.roky.thunderspi.repositories;


import com.roky.thunderspi.entities.UserQuizTake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuizTakeRepository extends JpaRepository<UserQuizTake,Long> {
}