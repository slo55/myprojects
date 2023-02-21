package be.multimedi.springfilms.service;

import be.multimedi.springfilms.model.RoleName;
import be.multimedi.springfilms.model.User;
import be.multimedi.springfilms.repository.RoleRepository;
import be.multimedi.springfilms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    @Override
    public User registerNewUser(User user)
    {
        // check that id isn't already in use
        if (user.getId() != null)
        {
            throw new IllegalArgumentException("Id must be empty!");
        }

        // check that email isn't already in use
        if(userRepository.existsByEmail(user.getEmail()) )
        {
            throw new EntityExistsException("Email is already taken");
        }

        // encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // add user role
        user.addRole(roleRepository.findByName(RoleName.USER));

        return userRepository.save(user);
    }
}
