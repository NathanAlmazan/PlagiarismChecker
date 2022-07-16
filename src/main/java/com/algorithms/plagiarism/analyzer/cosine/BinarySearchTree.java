package com.algorithms.plagiarism.analyzer.cosine;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void addNode(String value, int count) {
        root = addRecursive(root, value, count);
    }

    public Node getRoot() {
        return root;
    }

    private Node addRecursive(Node current, String value, int count) {
        if (current == null) return new Node(value, count);

        if (matchString(value, current.value)) {
            (current.count)++;
            return current;
        }

        if (value.compareToIgnoreCase(current.value) > 0) current.right = addRecursive(current.right, value, count);
        else current.left = addRecursive(current.left, value, count);

        return current;
    }

    public Node searchElement(Node node, String target) {
        if (node != null) {
            if (matchString(target, node.value)) return node;

            if (target.compareToIgnoreCase(node.value) > 0) return searchElement(node.right, target);
            return searchElement(node.left, target);
        }
        return null;
    }

    public double summationOfValues(Node node) {
        if (node != null) return (square(node.count) + summationOfValues(node.left) + summationOfValues(node.right));
        return 0;
    }

    private double square(double i) { return i * i; }

    private boolean matchString(String word, String pattern) {

        if (word.length() < pattern.length()) {
            String temp = pattern;
            pattern = word;
            word = temp;
        }

        if ((word.length() - pattern.length()) > 2) return false;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if ((i + j) > word.length() - 1) return false;
                else if (word.charAt(i + j) != pattern.charAt(j))
                    break;
                else if (j == (pattern.length() - 1)) return true;
            }
        }

        return false;
    }
}

