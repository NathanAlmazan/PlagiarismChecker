package com.algorithms.plagiarism.assignment.models;

import com.algorithms.plagiarism.accounts.models.StudentModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "classroom")
public class ClassroomModel {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long classroomId;

    @Column(name = "class_code", nullable = false, length = 10, unique = true)
    private String classroomCode;

    @Column(name = "class_name", nullable = false, length = 20)
    private String classroomName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId", nullable = false)
    private SubjectModel classSubject;

    @ManyToMany(mappedBy = "classrooms", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<StudentModel> enrolledStudents;

    @OneToMany(mappedBy = "classAssignments", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<AssignmentModel> assignments;
}
