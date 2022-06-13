package com.algorithms.plagiarism.accounts.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, String> {
}
