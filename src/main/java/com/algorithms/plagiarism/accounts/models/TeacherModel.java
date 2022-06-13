package com.algorithms.plagiarism.accounts.models;

import com.algorithms.plagiarism.assignment.models.SubjectModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "teacher")
public class TeacherModel {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long teacherId;

    @Column(name = "specialization", nullable = false, length = 20)
    private String specialization;

    @Column(name = "school", nullable = false, length = 50)
    private String schoolName;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "account_uid", referencedColumnName = "account_uid", nullable = false)
    private AccountModel teacherAccount;

    @OneToMany(mappedBy = "subjectTeacher")
    @JsonBackReference
    private List<SubjectModel> subjects;
}
