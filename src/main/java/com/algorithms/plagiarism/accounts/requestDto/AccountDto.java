package com.algorithms.plagiarism.accounts.requestDto;

import com.algorithms.plagiarism.accounts.models.AccountModel;
import com.algorithms.plagiarism.accounts.models.StudentModel;
import com.algorithms.plagiarism.accounts.models.TeacherModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    private String account_uid;
    private String firstName;
    private String lastName;
    private String email;
    private String provider;
    private Character accountType;
    private TeacherDto teacher;
    private StudentDto student;

    public AccountDto(AccountModel accountModel) {
        account_uid = accountModel.getAccount_uid();
        firstName = accountModel.getFirstName();
        lastName = accountModel.getLastName();
        email = accountModel.getEmail();
        provider = accountModel.getProvider();
        accountType = accountModel.getAccountType();

        if (accountModel.getTeacher() != null) {
            teacher = new TeacherDto(accountModel.getTeacher());
        }

        if (accountModel.getStudent() != null) {
            student = new StudentDto(accountModel.getStudent());
        }
    }
}
