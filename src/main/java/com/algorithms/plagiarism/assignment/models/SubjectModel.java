package com.algorithms.plagiarism.assignment.models;

import com.algorithms.plagiarism.accounts.models.TeacherModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "subject")
public class SubjectModel {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long subjectId;

    @Column(name = "sub_title", nullable = false, length = 50)
    private String subjectTitle;

    @Column(name = "sub_description", nullable = false, length = 70)
    private String subjectDescription;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId", nullable = false)
    private TeacherModel subjectTeacher;

    @OneToMany(mappedBy = "classSubject", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<ClassroomModel> classrooms;
}
