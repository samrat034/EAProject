package mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.BlockDAO;
import mum.edu.dao.CourseDAO;
import mum.edu.domain.Block;
import mum.edu.domain.Course;
@Transactional
public class CourseService {

    @Autowired
    private BlockDAO blockDao;
    @Autowired
    private CourseDAO courseDao;

   

    public void createCourse(Course course) {
        courseDao.save(course);
    }

    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    public Course getCourse(int courseId) {
        return courseDao.findOne(courseId);
    }

    public Course updateCourse(Course course) {
        return courseDao.save(course);
    }

    public void deleteCourse(int courseId) {
        courseDao.delete(courseId);
    }

    public void addPrerequisite(int courseId, int prerequisiteId) {
        Course course = courseDao.findOne(courseId);
        Course prerequisite = courseDao.findOne(prerequisiteId);
        course.addPrerequisite(prerequisite);
        courseDao.save(course);
    }

    public void deletePrerequisite(int courseId, int prerequisiteId) {
        Course course = courseDao.findOne(courseId);
        Course prerequisite = courseDao.findOne(prerequisiteId);
        course.removePrerequisite(prerequisite);
        courseDao.save(course);
    }

    public void addBlockCourse(String name, int blockId, int courseId) {
        Block block = blockDao.findOne(blockId);
        Course course = courseDao.findOne(courseId);
        block.addCourse(course);
        blockDao.save(block);
    }

}
