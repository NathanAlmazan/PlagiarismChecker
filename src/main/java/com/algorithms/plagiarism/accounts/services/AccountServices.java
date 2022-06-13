package com.algorithms.plagiarism.accounts.services;

import com.algorithms.plagiarism.accounts.models.AccountModel;
import com.algorithms.plagiarism.accounts.models.AccountRepository;
import com.algorithms.plagiarism.errors.types.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServices {
    @Autowired private AccountRepository accountRepository;

    public AccountModel createNewAccount(AccountModel newAccount) {
        return accountRepository.save(newAccount);
    }

    public AccountModel getAccountByUid(String account) {
        return accountRepository.findById(account).orElseThrow(() -> {
            throw new EntityNotFoundException("Account with UID of " + account + " not found.");
        });
    }

    public AccountModel updateAccountInfo(String uid, AccountModel updated) {
        return accountRepository.findById(uid)
                .map(account -> {
                    account.setFirstName(updated.getFirstName());
                    account.setLastName(updated.getLastName());
                    account.setAccountType(updated.getAccountType());

                    return accountRepository.save(account);
                }).orElseThrow(() -> {
                    throw new EntityNotFoundException("Account with UID of " + uid + " not found.");
                });
    }

    public AccountModel deleteAccount(String uid) {
        AccountModel deletedAccount = accountRepository.findById(uid)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Account with UID of " + uid + " not found.");
                });

        accountRepository.deleteById(uid);

        return deletedAccount;
    }
}
