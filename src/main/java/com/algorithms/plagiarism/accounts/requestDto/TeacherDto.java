package com.algorithms.plagiarism.accounts.requestDto;

import com.algorithms.plagiarism.accounts.models.TeacherModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class TeacherDto {
    private Long teacherId;
    @NotNull private String accountUid;
    @NotNull private String firstName;
    @NotNull private String lastName;
    @NotNull private String provider;
    @NotNull private String school;
    @NotNull private String specialization;

    @NotNull
    @Email
    private String email;

    public TeacherDto(TeacherModel teacherModel) {
        teacherId = teacherModel.getTeacherId();
        specialization = teacherModel.getSpecialization();
        school = teacherModel.getSchoolName();
    }
}
