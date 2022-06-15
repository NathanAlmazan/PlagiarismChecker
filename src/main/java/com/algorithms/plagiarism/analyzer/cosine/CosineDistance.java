package com.algorithms.plagiarism.analyzer.cosine;

import lombok.Getter;

import java.util.LinkedList;

@Getter
public class CosineDistance {
    private LinkedList<String> similarSentences;
    private HashTable similarWords;
    private final double cosineDistance;

    public CosineDistance(String textA, String textB, boolean collectSentences) {
        String[] setA = textA.split(">");
        String[] setB = textB.split(">");

        BinarySearchTree btreeA = new BinarySearchTree();
        BinarySearchTree btreeB = new BinarySearchTree();

        for (String word : setA) {
            if (word.length() > 2) {
                btreeA.addNode(word, 1);
                if (btreeB.searchElement(btreeB.getRoot(), word) == null) btreeB.addNode(word, 0);
            }
        }

        for (String word : setB) {
            if (word.length() > 2) {
                btreeB.addNode(word, 1);
                if (btreeA.searchElement(btreeA.getRoot(), word) == null) btreeA.addNode(word, 0);
            }
        }

        cosineDistance = summationOfIntersection(btreeA.getRoot(), btreeB) / Math.sqrt(btreeA.summationOfValues(btreeA.getRoot()) * btreeB.summationOfValues(btreeB.getRoot()));

        if (collectSentences) {
            similarWords = new HashTable(setA.length);
            collectSimilarWords(btreeA.getRoot(), btreeB);
            similarSentences = setSimilarSentences(textA);
        }
    }

    public LinkedList<String> setSimilarSentences(String textA) {
        LinkedList<String> plagiarizedSentences = new LinkedList<>();
        String[] sentences = textA.split("%");

        for (String sentence : sentences) {
            double score = scoreSentence(sentence);
            if (score > 0.60) plagiarizedSentences.add(sentence);
        }

        return plagiarizedSentences;
    }

    private double summationOfIntersection(Node node, BinarySearchTree source) {
        if (node != null) {
            return (source.searchElement(source.getRoot(), node.value).count * node.count) +
                    summationOfIntersection(node.left, source) + summationOfIntersection(node.right, source);
        }
        return 0;
    }

    private void collectSimilarWords(Node node, BinarySearchTree source) {
        if (node != null) {
            collectSimilarWords(node.left, source);

            Node result = source.searchElement(source.getRoot(), node.value);
            if (result.count > 0 && node.count > 0) similarWords.add(node.value);

            collectSimilarWords(node.right, source);
        }
    }

    private double scoreSentence(String sentence) {
        String[] words = sentence.split(">");

        if (words.length > 0) {
            int score = 0;
            for (String word : words) {
                if (word.length() > 2 && similarWords.get(word) != null) score++;
            }
            return (double)score / (double)words.length;
        }

        return 0;
    }
}
