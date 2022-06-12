package com.algorithms.plagiarism.errors.types;

public class FileConversionFailed extends RuntimeException {
    public FileConversionFailed() {
        super("Converting file to text failed.");
    }
}
