package com.algorithms.plagiarism.accounts.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
