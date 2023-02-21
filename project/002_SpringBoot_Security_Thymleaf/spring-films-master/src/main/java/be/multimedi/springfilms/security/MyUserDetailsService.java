package be.multimedi.springfilms.security;

import be.multimedi.springfilms.model.User;
import be.multimedi.springfilms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService
{

    private final UserRepository userRepository;

    @Override
    @Transactional                  // stream yapıldığı için trasactional olması gereklidir.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User fetchedUser = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email doesn't exist!"));



        return new MyUserDetails(fetchedUser);
    }
}
