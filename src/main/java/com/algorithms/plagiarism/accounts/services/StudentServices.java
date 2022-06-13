package com.algorithms.plagiarism.accounts.services;

import com.algorithms.plagiarism.accounts.models.StudentRepository;
import com.algorithms.plagiarism.accounts.models.StudentModel;
import com.algorithms.plagiarism.errors.types.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {
    @Autowired private StudentRepository studentRepository;

    public StudentModel createNewStudent(StudentModel newStudent) {
        return studentRepository.save(newStudent);
    }

    public StudentModel getStudentBy(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Student with ID of " + studentId + " not found.");
                });
    }

    public StudentModel updateStudentInfo(Long id, StudentModel updated) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setLevel(updated.getLevel());

                    return studentRepository.save(student);
                })
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Student with ID of " + id + " not found.");
                });
    }

    public StudentModel deleteStudent(Long studentId) {
        StudentModel deletedStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Student with ID of " + studentId + " not found.");
                });

        studentRepository.deleteById(studentId);

        return deletedStudent;
    }
}
