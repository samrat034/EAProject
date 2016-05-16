package mum.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.domain.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUsername(String username);
}

