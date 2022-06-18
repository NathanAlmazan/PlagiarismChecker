package com.algorithms.plagiarism.analyzer.services;

import com.algorithms.plagiarism.analyzer.models.FileStorage;
import com.algorithms.plagiarism.analyzer.models.FileStorageRepository;
import com.algorithms.plagiarism.assignment.models.AssignmentModel;
import com.algorithms.plagiarism.assignment.models.AssignmentRepository;
import com.algorithms.plagiarism.errors.types.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class FileStorageCrud {
    @Autowired private FileStorageRepository fileStorageRepository;
    @Autowired private AssignmentRepository assignmentRepository;
    @Autowired private EntityManager entityManager;

    public FileStorage insertFile(FileStorage newFile, Long assignid) {
        AssignmentModel assignment = assignmentRepository.findById(assignid).orElseThrow(() -> {
            throw new EntityNotFoundException("Assignment not found.");
        });
        newFile.setAssignment(assignment);

        return fileStorageRepository.save(newFile);
    }

    public List<FileStorage> getAllFiles() {
        return fileStorageRepository.findAll();
    }

    public List<FileStorage> getAllFilesWithException(List<Long> fileIds, Long assignId) {
        TypedQuery<FileStorage> query = entityManager.createQuery(
                "SELECT f FROM FileStorage f WHERE f.file_id NOT IN :fileIds AND f.assignment.assignmentId = :assignId", FileStorage.class);

        return query.setParameter("fileIds", fileIds)
                .setParameter("assignId", assignId)
                .getResultList();
    }

    public FileStorage getFileById(Long fileId) {
        return fileStorageRepository.findById(fileId).orElseThrow(() -> {
            throw new EntityNotFoundException("File with ID of " + fileId + " not found.");
        });
    }

    public void deleteFile(Long fileId) {
        if (fileStorageRepository.existsById(fileId)) fileStorageRepository.deleteById(fileId);
        else throw new EntityNotFoundException("File with ID of " + fileId + " not found.");
    }

    public FileStorage updateFileInformation(Long fileId, Long plagiarizedId, Double originality) {
        FileStorage plagiarizedFile = fileStorageRepository.findById(plagiarizedId).orElseThrow(() -> {
            throw new EntityNotFoundException("File with ID " + plagiarizedId + " not found.");
        });

        FileStorage updated = fileStorageRepository.findById(fileId).map(file -> {
            file.setOriginalityScore(originality);
            file.setParent(plagiarizedFile);

            return fileStorageRepository.save(file);
        }).orElseThrow(() -> {
            throw new EntityNotFoundException("File with ID " + fileId + " not found.");
        });

        return updated;
    }

    public FileStorage saveOriginality(Long fileId, Double originality) {
        FileStorage updated = fileStorageRepository.findById(fileId).map(file -> {
            file.setOriginalityScore(originality);

            return fileStorageRepository.save(file);
        }).orElseThrow(() -> {
            throw new EntityNotFoundException("File with ID " + fileId + " not found.");
        });

        return updated;
    }

    public FileStorage getFIleByUId(String uid) {
        FileStorage file = fileStorageRepository.findByFileUid(uid);
        if (file == null) throw new EntityNotFoundException("File not found.");

        return file;
    }
}
