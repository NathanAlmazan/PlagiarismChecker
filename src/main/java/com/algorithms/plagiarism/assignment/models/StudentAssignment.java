package com.algorithms.plagiarism.assignment.models;

import com.algorithms.plagiarism.accounts.models.StudentModel;
import com.algorithms.plagiarism.analyzer.models.FileStorage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_assignment")
public class StudentAssignment {
    @EmbeddedId
    private StudentAssignKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    @JsonManagedReference
    private StudentModel student;

    @ManyToOne
    @MapsId("assignmentId")
    @JoinColumn(name = "assign_id")
    @JsonManagedReference
    private AssignmentModel assignment;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_finished")
    private Date dateFinished;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "file_id", referencedColumnName = "file_id",nullable = false)
    private FileStorage assignFile;

    @Column(name = "assign_score")
    private Double score;
}
