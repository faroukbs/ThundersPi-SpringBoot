package com.roky.thunderspi.repositories;

import com.roky.thunderspi.entities.ProjectSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectSubmissionRepo extends JpaRepository<ProjectSubmission,Long> {
}
