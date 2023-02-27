package com.soysaltech.bankeroApp.repository;


import com.soysaltech.bankeroApp.entity.Role;
import com.soysaltech.bankeroApp.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
    Role findByName(RoleName userRoleName);
}
