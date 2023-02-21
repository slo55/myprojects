package be.multimedi.springfilms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration                                          // @Component beans registration
public class SecurityConfig                           // before :  extends WebSecurityConfigurerAdapter
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf().disable()      //cross-side request hacking is disabled.
                .authorizeRequests()
                .mvcMatchers("/", "/login", "/css/**","/register").permitAll()              // everyone can go to films page
                .anyRequest().authenticated()                               // hier to be logged
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout().permitAll();

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


}
