package com.algorithms.plagiarism.assignment.services;

import com.algorithms.plagiarism.accounts.models.TeacherModel;
import com.algorithms.plagiarism.accounts.models.TeacherRepository;
import com.algorithms.plagiarism.assignment.models.ClassroomModel;
import com.algorithms.plagiarism.assignment.models.ClassroomRepository;
import com.algorithms.plagiarism.assignment.models.SubjectModel;
import com.algorithms.plagiarism.assignment.models.SubjectRepository;
import com.algorithms.plagiarism.errors.types.EntityNotFoundException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ClassServices {
    @Autowired private SubjectRepository subjectRepository;
    @Autowired private ClassroomRepository classroomRepository;
    @Autowired private TeacherRepository teacherRepository;
    @Autowired private EntityManager entityManager;

    public SubjectModel createNewSubject(SubjectModel newSubject, Long teacherId) {
        TeacherModel teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Teacher ID " + teacherId + " not found.");
                });
        newSubject.setSubjectTeacher(teacher);

        return subjectRepository.save(newSubject);
    }

    public ClassroomModel createNewClassroom(Long subjectId, String name) {
        ClassroomModel newClass = new ClassroomModel();
        SubjectModel subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Subject ID " + subjectId+ " not found.");
                });

        newClass.setClassroomName(name);
        newClass.setClassSubject(subject);
        newClass.setClassroomCode(RandomStringUtils.randomAlphanumeric(10));

        return classroomRepository.save(newClass);
    }

    public List<SubjectModel> getTeacherSubjects(Long teacherId) {
        TypedQuery<SubjectModel> query = entityManager.createQuery("SELECT s FROM SubjectModel s WHERE s.subjectTeacher.teacherId = :teacherId", SubjectModel.class);
        List<SubjectModel> subjects = query.setParameter("teacherId", teacherId).getResultList();

        return subjects;
    }
}
