package mum.edu.controller;
import mum.edu.dao.BlockDAO;
import mum.edu.dao.CourseDAO;
import mum.edu.dao.RegistrationDao;

import mum.edu.dao.UserRoleDAO;
import mum.edu.domain.Block;
import mum.edu.domain.Course;
import mum.edu.domain.Registration;
import mum.edu.domain.User;
import mum.edu.domain.UserRole;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mum.edu.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    UserDAO userDao;
    @Autowired
    CourseDAO courseDao;
    @Autowired
    BlockDAO blockDao;
    @Autowired
    RegistrationDao registrationDao;
    @Autowired
    UserRoleDAO userRolesDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/initDb", method = RequestMethod.GET)
    public String initDb() {
        UserRole userRoles1 = new UserRole("john", "ROLE_USER");
        userRolesDao.save(userRoles1);
        UserRole userRoles2 = new UserRole("jane", "ROLE_USER");
        userRolesDao.save(userRoles2);
        UserRole userRoles3 = new UserRole("admin", "ROLE_ADMIN");
        userRolesDao.save(userRoles3);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user1 = new User("984511", "john", encoder.encode("123"), "John", "Doe", true);
        userDao.save(user1);
        User user2 = new User("984512", "jane", encoder.encode("123"), "Jane", "Doe", true);
        userDao.save(user2);
        User admin = new User("984513", "admin", encoder.encode("123"), "Admin", "", true);
        userDao.save(admin);

        Course course1 = new Course(1, "CS 390", "Fundamental Programming Practices", "This course provides a focused program for enhancing programming and analytical skills in five areas", null, "Professor ...", 0);
        Course course2 = new Course(2, "CS 401", "Modern Programming Practices", "Current Concepts and Best Practices in Software Development — Knowledge is the Basis of Action", null, "Professor ...", 0);
        Course course3 = new Course(3, "CS 422", "Database Systems", "Capturing the Organizing Power of Information", null, "Professor ...", 0);
        Course course4 = new Course(4, "CS 423", "Systems Analysis and Design", "The systems approach is an organized way of dealing with a problem", null, "Professor ...", 0);
        Course course5 = new Course(5, "CS 425", "Software Engineering", "Knowledge Is the Basis of Action — Principles and Processes for Developing Large-Scale Software Systems", null, "Professor ...", 0);
        Course course6 = new Course(6, "CS 428", "Software Development with Fund. Design Patterns", "This course is an introduction to 23 GoF (Gang of Four) design patterns.", null, "Professor ...", 0);
        courseDao.save(course1);
        courseDao.save(course2);
        courseDao.save(course3);
        courseDao.save(course4);
        courseDao.save(course5);
        courseDao.save(course6);

        List<Course> firstBlockCourses = new ArrayList<Course>();
        firstBlockCourses.add(course1);
        List<Course> secondBlockCourses = new ArrayList<Course>();
        firstBlockCourses.add(course2);
        List<Course> thirdBlockCourses = new ArrayList<Course>();
        thirdBlockCourses.add(course3);
        thirdBlockCourses.add(course4);
        thirdBlockCourses.add(course5);
        thirdBlockCourses.add(course6);

        Block block1 = new Block(firstBlockCourses, new Date(2016, 1, 1));
        Block block2 = new Block(secondBlockCourses, new Date(2016, 2, 1));
        Block block3 = new Block(thirdBlockCourses, new Date(2016, 3, 1));
        Block block4 = new Block(thirdBlockCourses, new Date(2016, 4, 1));
        Block block5 = new Block(thirdBlockCourses, new Date(2016, 5, 1));
        blockDao.save(block1);
        blockDao.save(block2);
        blockDao.save(block3);
        blockDao.save(block4);
        blockDao.save(block5);

        registrationDao.save(new Registration(user1, course1, block1));
        registrationDao.save(new Registration(user1, course2, block2));
        registrationDao.save(new Registration(user1, course3, block3));

        registrationDao.save(new Registration(user2, course1, block1));
        registrationDao.save(new Registration(user2, course2, block2));
        registrationDao.save(new Registration(user2, course4, block3));
        return "index";
    }

}
