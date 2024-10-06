package com.example.user_service.repository;

import com.example.user_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
    Set<Role> findAllByIdIn(List<Long> lisfOfIds);
}