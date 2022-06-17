package com.algorithms.plagiarism.assignment.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class SubjectDto {
    @NotNull
    @Length(min = 1, max = 50)
    private String subjectTitle;

    @NotNull
    @Length(min = 1, max = 70)
    private String subjectDescription;

    private Long teacherId;

    private Long subjectId;
}
