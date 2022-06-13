package com.algorithms.plagiarism.accounts.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    @NotNull private String accountUid;
    @NotNull private String firstName;
    @NotNull private String lastName;
    @NotNull private String provider;
    @NotNull private String level;

    @NotNull
    @Email
    private String email;
}
