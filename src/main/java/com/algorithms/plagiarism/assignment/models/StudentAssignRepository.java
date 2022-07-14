package com.algorithms.plagiarism.assignment.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentAssignRepository extends JpaRepository<StudentAssignment, StudentAssignKey> {

    @Query(value = "SELECT * FROM student_assignment WHERE student_id = :id", nativeQuery = true)
    List<StudentAssignment> findStudentSubmittedAssignments(@Param("id") Long studentId);

    @Query(value = "SELECT * FROM student_assignment WHERE file_id = ?1", nativeQuery = true)
    StudentAssignment findByAssignFile(Long fileId);
}
