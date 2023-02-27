package com.soysaltech.bankeroApp.security;


import com.soysaltech.bankeroApp.entity.User;
import com.soysaltech.bankeroApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService
{

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User fetchedUser = userRepository.findByIBAN(username).orElseThrow(() -> new UsernameNotFoundException(""));

        return new MyUserDetails(fetchedUser);
    }




}
