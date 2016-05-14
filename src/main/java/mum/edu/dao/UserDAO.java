package mum.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.User;
@Transactional(propagation=Propagation.MANDATORY)
public interface UserDAO extends JpaRepository<User, Integer> {

    public User findByUsernameAndPassword(String username, String password);
    
    public User findByUsername(String username);


}
