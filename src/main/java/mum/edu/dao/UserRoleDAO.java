package mum.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.UserRole;
@Transactional
@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUsername(String username);
}

