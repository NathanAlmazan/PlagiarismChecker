package com.algorithms.plagiarism.assignment;

import com.algorithms.plagiarism.assignment.models.AssignmentModel;
import com.algorithms.plagiarism.assignment.models.ClassroomModel;
import com.algorithms.plagiarism.assignment.models.StudentAssignment;
import com.algorithms.plagiarism.assignment.models.SubjectModel;
import com.algorithms.plagiarism.assignment.requestDto.*;
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

        return new ResponseEntity<>(classServices.createNewSubject(
                subject,
                newSubject.getTeacherId()
        ), HttpStatus.CREATED);
    }

    @PostMapping("/subject/edit")
    public ResponseEntity<SubjectModel> editSubject(@Valid @RequestBody SubjectDto body) {
        return new ResponseEntity<>(classServices.editSubject(
                body.getSubjectId(),
                body.getSubjectTitle(),
                body.getSubjectDescription()
        ), HttpStatus.OK);
    }

    @GetMapping("/subject/delete/{subjectId}")
    public ResponseEntity<SubjectModel> deleteSubject(@PathVariable("subjectId") Long subjectId) {
        return new ResponseEntity<>(classServices.deleteSubject(subjectId), HttpStatus.OK);
    }

    @PostMapping("/room/create")
    public ResponseEntity<ClassroomModel> createNewClassroom(@Valid @RequestBody ClassroomDto newClassroom) {
        return new ResponseEntity<>(classServices.createNewClassroom(
                newClassroom.getSubjectId(),
                newClassroom.getClassName()
        ), HttpStatus.CREATED);
    }

    @GetMapping("/room/data/{classCode}")
    public ResponseEntity<ClassroomModel> getClassroom(@PathVariable("classCode") String classCode) {
        return new ResponseEntity<>(classServices.getClassroomData(classCode), HttpStatus.OK);
    }

    @PostMapping("/room/edit")
    public ResponseEntity<ClassroomModel> editClassroom(@Valid @RequestBody ClassroomDto body) {
        return new ResponseEntity<>(classServices.editClassroomInformation(
                body.getClassId(),
                body.getSubjectId(),
                body.getClassName()
        ), HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/room/remove/{roomId}")
    public ResponseEntity<ClassroomModel> deleteClassroom(@PathVariable("roomId") Long roomId) {
        return new ResponseEntity<>(classServices.deleteClassroom(roomId), HttpStatus.OK);
    }

    @PostMapping("/room/enroll")
    public ResponseEntity<ClassroomModel> addStudentToClassroom(@Valid @RequestBody EnrollDto enrollStudent) {
        return new ResponseEntity<>(classServices.registerStudentToClass(
                enrollStudent.getStudentId(),
                enrollStudent.getClassCode()
        ), HttpStatus.CREATED);
    }

    @PostMapping("/assignment/submit")
    public ResponseEntity<StudentAssignment> submitAssignment(@Valid @RequestBody StudentAssignDto body) {
        return new ResponseEntity<>(classServices.saveStudentAssignment(
                body.getStudentId(),
                body.getAssignId(),
                body.getFileId()
        ), HttpStatus.CREATED);
    }

    @PostMapping("/assignment/create")
    public ResponseEntity<AssignmentModel> createAssignment(@Valid @RequestBody AssignmentDto body) {
        return new ResponseEntity<>(classServices.createNewAssignment(body), HttpStatus.OK);
    }

    @PostMapping("/assignment/update")
    public ResponseEntity<AssignmentModel> updateAssignment(@Valid @RequestBody AssignmentDto body) {
        return new ResponseEntity<>(classServices.updateAssignmentData(body), HttpStatus.OK);
    }

    @GetMapping("/assignment/delete/{assignId}")
    public ResponseEntity<AssignmentModel> deleteAssignment(@PathVariable("assignId") Long assignId) {
        return new ResponseEntity<>(classServices.deleteAssignment(assignId), HttpStatus.OK);
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
