package mum.edu.service;

import java.util.ArrayList;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.CourseDAO;
import mum.edu.dao.PendingCourseSwitchDAO;
import mum.edu.dao.RegistrationDao;
import mum.edu.dao.Registration_PreferedCoursesDAO;
import mum.edu.dao.UserDAO;
import mum.edu.domain.Course;
import mum.edu.domain.PendingCourseSwitch;
import mum.edu.domain.Registration;
import mum.edu.domain.Registration_PreferedCourses;
import mum.edu.domain.User;

@Transactional(propagation = Propagation.REQUIRES_NEW)

public class Registration_PreferedCourseService  {

    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private CourseDAO courseDao;
    @Autowired
    private UserDAO userDao;

    @Autowired
    private PendingCourseSwitchDAO pendingSwitchDao;
    @Autowired
    private Registration_PreferedCoursesDAO registration_PreferedCoursesDao;

   public List<Course> getPreferences(int courseId) {
	   List<Registration> regist=registrationDao.findByCourse_Id(courseId);
	   List<Course> courses=new ArrayList<Course>();
    	for(int i=0;i<regist.size();i++){
    		courses.add(regist.get(i).getCourse());
    	}
    return courses;
}

   //public boolean addPreferedCourse(String username, int registrationId, int courseId) {
//       List<Registration> allRegistrations = registrationDao.findAll();
//       List<Course> allCourses = courseDao.findAll();
//       User user = userDao.findByUsername(username);
//       Registration registration = allRegistrations.get(0);
//          for(int i=0;i<allRegistrations.size();i++){
//        	  
//        	  if(allRegistrations.get(i).getId()== registrationId){
//        		  registration= allRegistrations.get(i);
//        	  }
//          }
//        
//    		   allRegistrations.stream().filter(r -> r.getId() == registrationId).findFirst().get();
//       Course course = allCourses.stream().filter(r -> r.getId() == courseId).findFirst().get();
//       registration_PreferedCoursesDao.save(new Registration_PreferedCourses(registration, course));
//       registrationDao.save(registration);
//
//       if (course.getClassCapacity() > allRegistrations.stream().filter(r -> r.getCourse().equals(course)).count()) {
//           pendingSwitchDao.save(new PendingCourseSwitch(user, registration, course, false));
//
//           return true;
//       } else if (allRegistrations.stream().anyMatch(r -> r.getBlock().equals(registration.getBlock()) && r.getPreferedCourses().stream().map(pc -> pc.getCourse()).anyMatch(c -> c.equals(course)))) {
//           Optional<Registration> otherRegistration = allRegistrations.stream().filter(r -> r.getBlock().equals(registration.getBlock()) && r.getCourse().equals(course) && r.getPreferedCourses().stream().map(pc -> pc.getCourse()).anyMatch(c -> c.equals(registration.getCourse()))).findFirst();
//           if (otherRegistration.isPresent()) {
//               pendingSwitchDao.save(new PendingCourseSwitch(user, registration, course, true));
//               pendingSwitchDao.save(new PendingCourseSwitch(otherRegistration.get().getUser(), otherRegistration.get(), registration.getCourse(), true));
//               return true;
//           }
//       }
//       return false;
   //}

}