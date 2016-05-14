package mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.dao.CourseDAO;
import mum.edu.dao.PendingCourseSwitchDAO;
import mum.edu.dao.RegistrationDao;
import mum.edu.dao.Registration_PreferedCoursesDAO;
import mum.edu.dao.UserDAO;
import mum.edu.domain.Course;
import mum.edu.domain.Registration;

public class Registration_PreferedCourseService {

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

//    public List<Course> getPreferences(int courseId) {
//    	List<Registration> regist=registrationDao.findByCourse_Id(courseId);
//    	for(int i=0;i<regist.size())
//        return registrationDao.findByCourse_Id(courseId).stream()
//                .map(r -> r.getCourse()).collect(Collectors.toList());
   // }

}
