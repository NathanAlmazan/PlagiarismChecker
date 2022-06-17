package com.algorithms.plagiarism.analyzer.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {
    FileStorage findByFileUid(String uid);
}
