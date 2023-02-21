package be.multimedi.springfilms.console;

import be.multimedi.springfilms.model.User;
import be.multimedi.springfilms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("kickstart")
public class KickStart implements CommandLineRunner
{
    private final UserService userService;


    @Override
    public void run(String... args) throws Exception
    {
        User user = User.builder()
                .email("selim@gmail.com")
                .password("123")
                .build();

        userService.registerNewUser(user);
    }
}
