package com.algorithms.plagiarism.assignment.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Getter
public class StudentAssignDto {
    @NotNull private Long assignId;
    @NotNull private Long studentId;
    @NotNull private Long fileId;
}
