package com.algorithms.plagiarism.assignment.responseDto;

import com.algorithms.plagiarism.assignment.models.ClassroomModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClassroomResponseDto {
    private Long classroomId;
    private String classroomCode;
    private String classroomName;
    private SubjectDto classSubject;

    public ClassroomResponseDto(ClassroomModel classroomModel) {
        classroomId = classroomModel.getClassroomId();
        classroomCode = classroomModel.getClassroomCode();
        classroomName = classroomModel.getClassroomName();
        classSubject = new SubjectDto(classroomModel.getClassSubject());
    }
}
