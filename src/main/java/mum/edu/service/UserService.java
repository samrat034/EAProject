package mum.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.UserDAO;
import mum.edu.dao.UserRoleDAO;
import mum.edu.domain.User;
import mum.edu.domain.UserRole;
@Transactional(propagation=Propagation.MANDATORY)
public class UserService {
  @Autowired
  private UserDAO userDao;
  @Autowired 
  UserRoleDAO userRoleDao;

  public User getUser(String username){
	return userDao.findByUsername(username) ;
  }
  public User addUser(String id,String username,String firstname,String lastname,String password,boolean enabled){
	  return userDao.save(new User (id,username,firstname,lastname,password,enabled));
  }
  public List<String> getUserRoles(String username) {
	  List<UserRole> userRole= userRoleDao.findByUsername(username);
	  List<String> str=new ArrayList<String>();
	  for(int i=0;i<userRole.size();i++){
		  str.add(userRole.get(i).getRole());
	  }
      return str;
  }

}
