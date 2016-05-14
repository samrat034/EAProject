package mum.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import mum.edu.domain.Course;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface CourseDAO extends JpaRepository<Course, Integer> {
    
}