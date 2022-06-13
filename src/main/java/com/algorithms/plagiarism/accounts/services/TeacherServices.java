package com.algorithms.plagiarism.accounts.services;

import com.algorithms.plagiarism.accounts.models.TeacherModel;
import com.algorithms.plagiarism.accounts.models.TeacherRepository;
import com.algorithms.plagiarism.errors.types.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServices {
    @Autowired private TeacherRepository teacherRepository;

    public TeacherModel createNewTeacher(TeacherModel newTeacher) {
        return teacherRepository.save(newTeacher);
    }

    public TeacherModel getTeacherBy(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Teacher with ID of " + teacherId + " not found.");
                });
    }

    public TeacherModel updateTeacherInfo(Long id, TeacherModel updated) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setSpecialization(updated.getSpecialization());
                    teacher.setSchoolName(updated.getSchoolName());

                    return teacherRepository.save(teacher);
                })
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Teacher with ID of " + id + " not found.");
                });
    }

    public TeacherModel deleteTeacher(Long teacherId) {
        TeacherModel deletedTeacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Teacher with ID of " + teacherId + " not found.");
                });

        teacherRepository.deleteById(teacherId);

        return deletedTeacher;
    }
}
