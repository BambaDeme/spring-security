package com.deme.ahmadou.security.repository;

import com.deme.ahmadou.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findRoleByName(String name);
}
