package com.algorithms.plagiarism.assignment.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAssignRepository extends JpaRepository<StudentAssignment, StudentAssignKey> {
}
