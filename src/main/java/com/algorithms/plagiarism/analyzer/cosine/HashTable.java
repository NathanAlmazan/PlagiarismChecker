package com.algorithms.plagiarism.analyzer.cosine;

public class HashTable {
    private HashNode[] storage;
    private int storageSize;

    public HashTable(int size) {
        this.storage = new HashNode[size];
        this.storageSize = size;
    }

    private int getBucketIndex(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % storageSize);
    }

    public String get(String key) {
        int index = getBucketIndex(key);
        HashNode head = storage[index];

        while(head != null) {
            if (matchString(head.getValue(), key)) return head.getValue();
            head = head.nextNode;
        }
        return null;
    }

    public void add(String value) {
        int index = getBucketIndex(value);
        if (index > (storageSize - 1)) createNewArray();

        HashNode newItem = new HashNode(value);
        HashNode head = storage[index];

        if (head != null) newItem.nextNode = head;
        storage[index] = newItem;
    }

    private void createNewArray() {
        int newSize = storageSize * 2;
        HashNode[] newStorage = new HashNode[newSize];
        if (storageSize >= 0) System.arraycopy(storage, 0, newStorage, 0, newSize);

        this.storageSize = newSize;
        this.storage = newStorage;
    }

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