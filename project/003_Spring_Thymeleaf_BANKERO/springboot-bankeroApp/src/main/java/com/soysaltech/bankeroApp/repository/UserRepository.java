package com.soysaltech.bankeroApp.repository;

import java.util.Optional;
import com.soysaltech.bankeroApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    boolean existsByIBAN(String iban);
    Optional<User> findByIBAN(String iban);
}
