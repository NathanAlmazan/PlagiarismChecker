package com.algorithms.plagiarism.errors.types;

public class InternalErrorException extends RuntimeException {
    public InternalErrorException(String error) {
        super(error);
    }
}
