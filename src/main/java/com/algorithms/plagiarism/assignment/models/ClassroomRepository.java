package com.algorithms.plagiarism.assignment.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<ClassroomModel, Long> {
    ClassroomModel findByClassroomCode(String classroomCode);
}
