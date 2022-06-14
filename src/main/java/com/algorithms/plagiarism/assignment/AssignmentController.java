package com.algorithms.plagiarism.assignment;

import com.algorithms.plagiarism.accounts.models.StudentModel;
import com.algorithms.plagiarism.assignment.models.ClassroomModel;
import com.algorithms.plagiarism.assignment.models.SubjectModel;
import com.algorithms.plagiarism.assignment.requestDto.ClassroomDto;
import com.algorithms.plagiarism.assignment.requestDto.EnrollDto;
import com.algorithms.plagiarism.assignment.requestDto.SubjectDto;
import com.algorithms.plagiarism.assignment.services.ClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/class")
@Validated
public class AssignmentController {
    @Autowired private ClassServices classServices;

    @PostMapping("/subject/create")
    public ResponseEntity<SubjectModel> createNewSubject(@Valid @RequestBody SubjectDto newSubject) {
        SubjectModel subject = new SubjectModel();
        subject.setSubjectTitle(newSubject.getSubjectTitle());
        subject.setSubjectDescription(newSubject.getSubjectDescription());

        return new ResponseEntity<>(classServices.createNewSubject(subject, newSubject.getTeacherId()), HttpStatus.CREATED);
    }

    @PostMapping("/room/create")
    public ResponseEntity<ClassroomModel> createNewClassroom(@Valid @RequestBody ClassroomDto newClassroom) {
        return new ResponseEntity<>(classServices.createNewClassroom(newClassroom.getSubjectId(), newClassroom.getClassName()), HttpStatus.CREATED);
    }

    @PostMapping("/room/enroll")
    public ResponseEntity<ClassroomModel> addStudentToClassroom(@Valid @RequestBody EnrollDto enrollStudent) {
        return new ResponseEntity<>(classServices.registerStudentToClass(
                enrollStudent.getStudentId(),
                enrollStudent.getClassCode()
        ), HttpStatus.CREATED);
    }

    @GetMapping("/subject/find/{teacherId}")
    public ResponseEntity<List<SubjectModel>> getTeacherSubjects(@PathVariable("teacherId") Long teacherId) {
        return new ResponseEntity<>(classServices.getTeacherSubjects(teacherId), HttpStatus.OK);
    }

    @GetMapping("/room/find/{studentId}")
    public ResponseEntity<List<ClassroomModel>> getStudentClassrooms(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(classServices.getStudentSubjects(studentId), HttpStatus.OK);
    }
}
