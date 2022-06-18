package com.algorithms.plagiarism.assignment.models;

import com.algorithms.plagiarism.analyzer.models.FileStorage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "assignment")
public class AssignmentModel {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long assignmentId;

    @Column(name = "assign_title", nullable = false, length = 50)
    private String assignTitle;

    @Column(name = "assign_description", nullable = false)
    private String assignDesc;

    @Column(name = "assign_points", nullable = false)
    private Double assignPoints;

    @Column(name = "assign_due_date", nullable = false, columnDefinition = "DATE")
    private LocalDate assignDueDate;

    @Column(name = "assign_due_time", nullable = false, columnDefinition = "TIME")
    private LocalTime assignDueTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "class_id", referencedColumnName = "classroomId", nullable = false)
    private ClassroomModel classAssignments;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<StudentAssignment> students;

    @OneToMany(mappedBy = "assignment", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<FileStorage> submittedFiles;
}
