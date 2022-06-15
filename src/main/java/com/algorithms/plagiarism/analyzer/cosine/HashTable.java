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
            if (head.getValue().equals(key)) return head.getValue();
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
}