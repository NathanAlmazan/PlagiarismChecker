package com.algorithms.plagiarism.assignment.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ClassroomDto {
    @NotNull private Long subjectId;

    @NotNull
    @Length(min = 1, max = 20)
    private String className;

    private Long classId;
}
