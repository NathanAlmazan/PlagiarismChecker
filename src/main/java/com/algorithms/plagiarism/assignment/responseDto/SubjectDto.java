package com.algorithms.plagiarism.assignment.responseDto;

import com.algorithms.plagiarism.accounts.models.AccountModel;
import com.algorithms.plagiarism.assignment.models.SubjectModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDto {
    private String subjectName;
    private String teacherName;

    public SubjectDto(SubjectModel subjectModel) {
        AccountModel teacherAccount = subjectModel.getSubjectTeacher().getTeacherAccount();

        subjectName = subjectModel.getSubjectTitle();
        teacherName = teacherAccount.getFirstName() + " " + teacherAccount.getLastName();
    }
}
