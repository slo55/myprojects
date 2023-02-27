package com.soysaltech.bankeroApp.service;


import com.soysaltech.bankeroApp.entity.RoleName;
import com.soysaltech.bankeroApp.entity.User;
import com.soysaltech.bankeroApp.repository.RoleRepository;
import com.soysaltech.bankeroApp.repository.TransferRepository;
import com.soysaltech.bankeroApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TransferRepository transferRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public User registerNewUser(User user)
    {
        if (userRepository.existsByIBAN(user.getIBAN()))
        {
            throw new IllegalArgumentException("IBAN is already exist.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRole(roleRepository.findByName(RoleName.USER));


        return userRepository.save(user);
    }

    @Override
    public User getUserByIBAN(String iban)
    {
        return userRepository.findByIBAN(iban).orElseThrow();
    }

    @Override
    public void updateProfile(String iban, User updatedUser)
    {

    }

    @Override
    public void changeUserPasswordByIBAN(String oldPassword, String newPassword, String iban)
    {

    }









}
