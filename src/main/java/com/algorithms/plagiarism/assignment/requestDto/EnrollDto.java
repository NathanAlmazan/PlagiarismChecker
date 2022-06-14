package com.algorithms.plagiarism.assignment.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class EnrollDto {
    @NotNull private Long studentId;

    @NotNull @Length(min = 10, max = 10)
    private String classCode;
}
