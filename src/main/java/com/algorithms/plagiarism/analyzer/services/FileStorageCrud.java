package com.algorithms.plagiarism.analyzer.services;

import com.algorithms.plagiarism.analyzer.models.FileStorage;
import com.algorithms.plagiarism.analyzer.models.FileStorageRepository;
import com.algorithms.plagiarism.errors.types.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class FileStorageCrud {
    @Autowired private FileStorageRepository fileStorageRepository;
    @Autowired private EntityManager entityManager;

    public FileStorage insertFile(FileStorage newFile) {
        return fileStorageRepository.save(newFile);
    }

    public List<FileStorage> getAllFiles() {
        return fileStorageRepository.findAll();
    }

    public List<FileStorage> getAllFilesWithException(List<Long> fileIds) {
        TypedQuery<FileStorage> query = entityManager.createQuery("SELECT f FROM FileStorage f WHERE f.file_id NOT IN :fileIds", FileStorage.class);
        List<FileStorage> files = query.setParameter("fileIds", fileIds).getResultList();

        return files;
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
}
