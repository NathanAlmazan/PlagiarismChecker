package com.algorithms.plagiarism.analyzer.cosine;

public class HashNode {
    private final String value;
    public HashNode nextNode;

    public HashNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
