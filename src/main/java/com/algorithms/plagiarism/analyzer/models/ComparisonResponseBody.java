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
    private LinkedList<String> similarTerms;
    private LinkedList<String> sentencesA;
    private LinkedList<String> sentencesB;
}
