package com.soysaltech.bankeroApp.security;

import com.soysaltech.bankeroApp.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails
{
    private User user;
    private Set<GrantedAuthority> grantedAuthorities;


    public MyUserDetails(User user)
    {
        this.user = user;
        this.grantedAuthorities = user.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName().toString()))
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword()
    {
        return this.user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return this.user.getIBAN();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
