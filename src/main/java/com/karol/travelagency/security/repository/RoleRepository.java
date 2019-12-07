package com.karol.travelagency.security.repository;

import com.karol.travelagency.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByNameEquals(String name);
}
