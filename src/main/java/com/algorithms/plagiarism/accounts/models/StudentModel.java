package com.algorithms.plagiarism.accounts.models;

import com.algorithms.plagiarism.assignment.models.AssignmentModel;
import com.algorithms.plagiarism.assignment.models.ClassroomModel;
import com.algorithms.plagiarism.assignment.models.StudentAssignment;
import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentModel {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long studentId;

    @Column(name = "level", nullable = false, length = 10)
    private String level;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "account_uid", referencedColumnName = "account_uid", nullable = false)
    private AccountModel studentAccount;

    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "class_details",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "classroomId"))
    private List<ClassroomModel> classrooms;

    @OneToMany(mappedBy = "assignment")
    @JsonBackReference
    private List<StudentAssignment> assignments;
}
