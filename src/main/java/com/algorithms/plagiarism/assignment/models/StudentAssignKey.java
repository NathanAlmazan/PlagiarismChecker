package com.algorithms.plagiarism.assignment.models;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Embeddable
public class StudentAssignKey implements Serializable {
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "assign_id")
    private Long assignmentId;
}
