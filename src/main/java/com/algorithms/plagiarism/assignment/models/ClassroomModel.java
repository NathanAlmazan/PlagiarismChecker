package com.algorithms.plagiarism.assignment.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
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
@Table(name = "classroom")
public class ClassroomModel {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long classroomId;

    @Column(name = "class_code", nullable = false, length = 10)
    private String classroomCode;

    @Column(name = "class_name", nullable = false, length = 20)
    private String classroomName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId", nullable = false)
    private SubjectModel classSubject;
}
