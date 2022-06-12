package com.algorithms.plagiarism.analyzer.cosine;

public class Node {
    public String value;
    public Node left, right;
    public int count;

    public Node(String value, int count) {
        this.value = value;
        right = null;
        left = null;
        this.count = count;
    }
}
