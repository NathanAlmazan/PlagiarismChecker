package com.algorithms.plagiarism.assignment.services;

import com.algorithms.plagiarism.accounts.models.StudentModel;
import com.algorithms.plagiarism.accounts.models.StudentRepository;
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
    @Autowired private StudentRepository studentRepository;
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

    public List<ClassroomModel> getStudentSubjects(Long studentId) {
        String psql = "SELECT c FROM ClassroomModel c JOIN c.enrolledStudents s WHERE s.studentId = :id";
        TypedQuery<ClassroomModel> query = entityManager.createQuery(psql, ClassroomModel.class);

        return query.setParameter("id", studentId).getResultList();
    }

    public List<SubjectModel> getTeacherSubjects(Long teacherId) {
        String psql = "SELECT s FROM SubjectModel s WHERE s.subjectTeacher.teacherId = :teacherId";
        TypedQuery<SubjectModel> query = entityManager.createQuery(psql, SubjectModel.class);
        return query.setParameter("teacherId", teacherId).getResultList();
    }

    public ClassroomModel registerStudentToClass(Long studentId, String classCode) {
        StudentModel student = studentRepository.findById(studentId).orElseThrow(() -> {
            throw new EntityNotFoundException("Student ID " + studentId + " not found.");
        });

        ClassroomModel classroom = classroomRepository.findByClassroomCode(classCode);

        if (classroom == null) throw new EntityNotFoundException("Class with code " + classCode + " not found.");

        classroom.getEnrolledStudents().add(student);
        student.getClassrooms().add(classroom);

        return classroomRepository.save(classroom);
    }
}
