package com.algorithms.plagiarism.assignment.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AssignmentDto {
    @NotNull
    @Length(min = 1, max = 50)
    private String assignTitle;

    @NotNull
    @Length(min = 1, max = 250)
    private String assignDesc;

    @NotNull private Double assignPoints;
    @NotNull private Long classId;
    @NotNull private String assignDueDate;
    @NotNull private String assignDueTime;

    private Long assignmentId;
}
