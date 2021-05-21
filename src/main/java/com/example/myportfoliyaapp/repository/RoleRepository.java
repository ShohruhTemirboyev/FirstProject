package com.example.myportfoliyaapp.repository;

import com.example.myportfoliyaapp.entity.enam.Role;
import com.example.myportfoliyaapp.entity.enam.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(RoleName roleName);
}
