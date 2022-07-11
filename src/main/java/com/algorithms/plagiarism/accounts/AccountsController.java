package com.algorithms.plagiarism.accounts;

import com.algorithms.plagiarism.accounts.models.AccountModel;
import com.algorithms.plagiarism.accounts.models.StudentModel;
import com.algorithms.plagiarism.accounts.models.TeacherModel;
import com.algorithms.plagiarism.accounts.requestDto.AccountDto;
import com.algorithms.plagiarism.accounts.requestDto.StudentDto;
import com.algorithms.plagiarism.accounts.requestDto.TeacherDto;
import com.algorithms.plagiarism.accounts.services.AccountServices;
import com.algorithms.plagiarism.accounts.services.StudentServices;
import com.algorithms.plagiarism.accounts.services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/accounts")
@Validated
public class AccountsController {
    @Autowired private StudentServices studentServices;
    @Autowired private TeacherServices teacherServices;
    @Autowired private AccountServices accountServices;

    @PostMapping("/student/create")
    public ResponseEntity<StudentModel> createNewStudentAccount(@Valid @RequestBody StudentDto newStudent) {
        AccountModel newAccount = new AccountModel();
        newAccount.setAccount_uid(newStudent.getAccountUid());
        newAccount.setFirstName(newStudent.getFirstName());
        newAccount.setLastName(newStudent.getLastName());
        newAccount.setEmail(newStudent.getEmail());
        newAccount.setProvider(newStudent.getProvider());
        newAccount.setAccountType('S');

        StudentModel student = new StudentModel();
        student.setLevel(newStudent.getLevel());
        student.setStudentAccount(newAccount);

        return new ResponseEntity<>(studentServices.createNewStudent(student), HttpStatus.CREATED);
    }

    @PostMapping("/teacher/create")
    public ResponseEntity<TeacherModel> createNewTeacherAccount(@Valid @RequestBody TeacherDto newTeacher) {
        AccountModel newAccount = new AccountModel();
        newAccount.setAccount_uid(newTeacher.getAccountUid());
        newAccount.setFirstName(newTeacher.getFirstName());
        newAccount.setLastName(newTeacher.getLastName());
        newAccount.setEmail(newTeacher.getEmail());
        newAccount.setProvider(newTeacher.getProvider());
        newAccount.setAccountType('T');

        TeacherModel teacher = new TeacherModel();
        teacher.setSchoolName(newTeacher.getSchool());
        teacher.setSpecialization(newTeacher.getSpecialization());
        teacher.setTeacherAccount(newAccount);

        return new ResponseEntity<>(teacherServices.createNewTeacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping("/find/{uid}")
    public ResponseEntity<AccountDto> getAccountInformation(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(new AccountDto(accountServices.getAccountByUid(uid)), HttpStatus.OK);
    }
}
