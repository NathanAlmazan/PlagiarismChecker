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

        if (value.equals(current.value)) {
            (current.count)++;
            return current;
        }

        if (value.compareToIgnoreCase(current.value) > 0) current.right = addRecursive(current.right, value, count);
        else current.left = addRecursive(current.left, value, count);

        return current;
    }

    public Node searchElement(Node node, String target) {
        if (node != null) {
            if (target.equals(node.value)) return node;

            if (target.compareToIgnoreCase(node.value) > 0) return searchElement(node.right, target);
            return searchElement(node.left, target);
        }
        return null;
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.value + " -> " + node.count);
            traverseInOrder(node.right);
        }
    }

    public double summationOfValues(Node node) {
        if (node != null) return (square(node.count) + summationOfValues(node.left) + summationOfValues(node.right));
        return 0;
    }

    private double square(double i) { return i * i; }
}

