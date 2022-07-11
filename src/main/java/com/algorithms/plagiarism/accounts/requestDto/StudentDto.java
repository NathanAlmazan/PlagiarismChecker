package com.algorithms.plagiarism.accounts.requestDto;

import com.algorithms.plagiarism.accounts.models.StudentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long studentId;
    @NotNull private String accountUid;
    @NotNull private String firstName;
    @NotNull private String lastName;
    @NotNull private String provider;
    @NotNull private String level;

    @NotNull
    @Email
    private String email;

    public StudentDto(StudentModel studentModel) {
        studentId = studentModel.getStudentId();
        level = studentModel.getLevel();
    }
}
