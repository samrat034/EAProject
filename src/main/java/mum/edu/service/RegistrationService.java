package mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import mum.edu.dao.RegistrationDao;
import mum.edu.domain.Block;
import mum.edu.domain.Course;
import mum.edu.domain.Registration;
import mum.edu.domain.User;

@Transactional(propagation = Propagation.REQUIRES_NEW)

public class RegistrationService {
   @Autowired
   private RegistrationDao registrationDao;
   @Autowired
//   private PendingCourseSwitch pendingCourse;
//   @Autowired
//   private BlockDAO blockDao;
//   @Autowired
//   private CourseDAO courseDao;
//   @Autowired
//   private UserDAO userDao;

   

   public void register(User user, Block block, Course course, List<Course> preferedCourses) {
       registrationDao.save(new Registration(user,course,block ));
   }

  

}
