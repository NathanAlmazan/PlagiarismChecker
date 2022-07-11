package com.algorithms.plagiarism.assignment.services;

import com.algorithms.plagiarism.accounts.models.StudentModel;
import com.algorithms.plagiarism.accounts.models.StudentRepository;
import com.algorithms.plagiarism.accounts.models.TeacherModel;
import com.algorithms.plagiarism.accounts.models.TeacherRepository;
import com.algorithms.plagiarism.analyzer.models.FileStorage;
import com.algorithms.plagiarism.analyzer.models.FileStorageRepository;
import com.algorithms.plagiarism.assignment.models.*;
import com.algorithms.plagiarism.assignment.requestDto.AssignmentDto;
import com.algorithms.plagiarism.errors.types.EntityNotFoundException;
import com.algorithms.plagiarism.errors.types.InvalidRequestException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServices {
    @Autowired private SubjectRepository subjectRepository;
    @Autowired private ClassroomRepository classroomRepository;
    @Autowired private TeacherRepository teacherRepository;
    @Autowired private StudentRepository studentRepository;
    @Autowired private AssignmentRepository assignmentRepository;
    @Autowired private StudentAssignRepository studentAssignRepository;
    @Autowired private FileStorageRepository fileStorageRepository;
    @Autowired private EntityManager entityManager;

    public SubjectModel createNewSubject(SubjectModel newSubject, Long teacherId) {
        TeacherModel teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Teacher ID " + teacherId + " not found.");
                });
        newSubject.setSubjectTeacher(teacher);

        return subjectRepository.save(newSubject);
    }

    public SubjectModel editSubject(Long subjectId, String title, String description) {
        return subjectRepository.findById(subjectId).map(subject -> {
            subject.setSubjectTitle(title);
            subject.setSubjectDescription(description);

            return subjectRepository.save(subject);
        }).orElseThrow(() -> {
            throw new EntityNotFoundException("Subject not found,");
        });
    }

    public SubjectModel deleteSubject(Long subjectId) {
        SubjectModel deletedSubject = subjectRepository.findById(subjectId).orElseThrow(() -> {
            throw new EntityNotFoundException("Subject not found.");
        });

        if (deletedSubject.getClassrooms().size() > 0)
            throw new InvalidRequestException("Cannot delete subject that has active classes");


        subjectRepository.deleteById(subjectId);

        return deletedSubject;
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

    public ClassroomModel getClassroomData(String classCode) {
        ClassroomModel classroom = classroomRepository.findByClassroomCode(classCode);

        if (classroom == null) throw new EntityNotFoundException("Classroom with code of " + classCode + " not found.");

        return classroom;
    }

    public ClassroomModel editClassroomInformation(Long classId, Long subjectId, String className) {
        SubjectModel subject = subjectRepository.findById(subjectId).orElseThrow(() -> {
            throw new EntityNotFoundException("Subject not found.");
        });

        return classroomRepository.findById(classId)
                .map(room -> {
                    room.setClassroomName(className);
                    room.setClassSubject(subject);

                    return classroomRepository.save(room);
                }).orElseThrow(() -> {
                    throw new EntityNotFoundException("Classroom not found.");
                });
    }

    public ClassroomModel deleteClassroom(Long classId) {
        ClassroomModel deletedClass = classroomRepository.findById(classId).orElseThrow(() -> {
            throw new EntityNotFoundException("Classroom not found");
        });

        classroomRepository.deleteById(classId);

        return deletedClass;
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

    public StudentAssignment saveStudentAssignment(Long studentId, Long assignId, Long fileId) {
        StudentModel student = studentRepository.findById(studentId).orElseThrow(() -> {
            throw new EntityNotFoundException("Student ID " + studentId + " not found.");
        });

        AssignmentModel assignment = assignmentRepository.findById(assignId).orElseThrow(() -> {
            throw new EntityNotFoundException("Assignment ID " + assignId + " not found.");
        });

        FileStorage assignFile = fileStorageRepository.findById(fileId).orElseThrow(() -> {
            throw new EntityNotFoundException("File ID " + fileId + " not found.");
        });

        StudentAssignKey key = new StudentAssignKey();
        key.setAssignmentId(assignId);
        key.setStudentId(studentId);

        StudentAssignment studentAssign = new StudentAssignment();
        studentAssign.setStudent(student);
        studentAssign.setAssignment(assignment);
        studentAssign.setAssignFile(assignFile);
        studentAssign.setId(key);

        return studentAssignRepository.save(studentAssign);
    }

    public AssignmentModel createNewAssignment(AssignmentDto newAssignment) {
        LocalDate dueDate = LocalDate.parse(newAssignment.getAssignDueDate());
        LocalTime dueTime = LocalTime.parse(newAssignment.getAssignDueTime());

        ClassroomModel classroom = classroomRepository.findById(newAssignment.getClassId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Classroom not found.");
        });

        AssignmentModel assignment = new AssignmentModel();
        assignment.setAssignTitle(newAssignment.getAssignTitle());
        assignment.setAssignDesc(newAssignment.getAssignDesc());
        assignment.setAssignDueDate(dueDate);
        assignment.setAssignDueTime(dueTime);
        assignment.setAssignPoints(newAssignment.getAssignPoints());
        assignment.setClassAssignments(classroom);

        return assignmentRepository.save(assignment);
    }

    public AssignmentModel getAssignmentData(String classCode, Long assignmentId) {
        AssignmentModel assignment = assignmentRepository.findById(assignmentId).orElseThrow(() -> {
            throw new EntityNotFoundException("Assignment not found;");
        });

        if (!assignment.getClassAssignments().getClassroomCode().equals(classCode))
            throw new InvalidRequestException("cannot access this assignment.");

        return assignment;
    }

    public AssignmentModel updateAssignmentData(AssignmentDto updated) {
        LocalDate dueDate = LocalDate.parse(updated.getAssignDueDate());
        LocalTime dueTime = LocalTime.parse(updated.getAssignDueTime());

        ClassroomModel classroom = classroomRepository.findById(updated.getClassId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Classroom not found.");
        });

        return assignmentRepository.findById(updated.getAssignmentId()).map(assignment -> {
            assignment.setAssignTitle(updated.getAssignTitle());
            assignment.setAssignDesc(updated.getAssignDesc());
            assignment.setAssignDueDate(dueDate);
            assignment.setAssignDueTime(dueTime);
            assignment.setAssignPoints(updated.getAssignPoints());
            assignment.setClassAssignments(classroom);

            return assignmentRepository.save(assignment);
        }).orElseThrow(() -> {
            throw new EntityNotFoundException("Assignment not found.");
        });
    }

    public AssignmentModel deleteAssignment(Long assignmentId) {
        AssignmentModel existingAssign = assignmentRepository.findById(assignmentId).orElseThrow(() -> {
            throw new EntityNotFoundException("Assignment not found.");
        });

        assignmentRepository.deleteById(assignmentId);

        return existingAssign;
    }

    public List<Long> getStudentAssignment(Long studentId) {
        StudentModel student = studentRepository.findById(studentId).orElseThrow(() -> {
            throw new EntityNotFoundException("Student ID " + studentId + " not found.");
        });

        List<Long> assignments = new ArrayList<>();

        for (StudentAssignment assignment : studentAssignRepository.findStudentSubmittedAssignments(studentId))
            assignments.add(assignment.getId().getAssignmentId());

        return assignments;
    }
}
