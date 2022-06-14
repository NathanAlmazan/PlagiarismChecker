package com.algorithms.plagiarism.analyzer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.LinkedList;

@Setter
@Getter
@NoArgsConstructor
public class ComparisonResponseBody {
    private double cosineDistance;
    private LinkedList<String> similarSentences;
}
