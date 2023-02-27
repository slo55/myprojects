package com.soysaltech.bankeroApp.service;


import com.soysaltech.bankeroApp.entity.User;

public interface UserService
{
    User registerNewUser(User user);
    User getUserByIBAN(String iban);
    void updateProfile(String iban, User updatedUser);
    void changeUserPasswordByIBAN(String oldPassword, String newPassword, String iban);
}
