package be.multimedi.springfilms.repository;

import be.multimedi.springfilms.model.Role;
import be.multimedi.springfilms.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{

    Role findByName(RoleName user);
}
