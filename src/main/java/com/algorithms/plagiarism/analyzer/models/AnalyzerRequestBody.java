package com.algorithms.plagiarism.analyzer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AnalyzerRequestBody {
    @NotNull private Long documentId;
    @NotNull private List<Long> excludeDocuments;
}
