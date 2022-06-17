package com.algorithms.plagiarism.accounts.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account")
public class AccountModel {
    @Id
    @Column(name = "account_uid", unique = true, nullable = false, length = 30)
    private String account_uid;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "provider", nullable = false, length = 10)
    private String provider;

    @Column(name = "account_type", nullable = false, length = 10)
    private Character accountType;

    @OneToOne(mappedBy = "teacherAccount")
    @JsonManagedReference
    private TeacherModel teacher;

    @OneToOne(mappedBy = "studentAccount")
    @JsonBackReference
    private StudentModel student;
}
