package com.algorithms.plagiarism.analyzer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class ComparisonRequestBody {
    @NotNull private Long documentA;
    @NotNull private Long documentB;
}
