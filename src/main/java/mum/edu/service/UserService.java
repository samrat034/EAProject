package mum.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.UserDAO;
import mum.edu.domain.User;
@Transactional(propagation=Propagation.MANDATORY)
public class UserService {
  @Autowired
  private UserDAO userDao;
  
  public User getUser(String username){
	return userDao.findByUsername(username) ;
  }
  public User addUser(String id,String username,String firstname,String lastname,String password,boolean enabled){
	  return userDao.save(new User (id,username,firstname,lastname,password,enabled));
  }
}
