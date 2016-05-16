package mum.edu.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Registration_PreferedCourses;

@Transactional(propagation = Propagation.MANDATORY)
@Repository
public interface Registration_PreferedCoursesDAO extends JpaRepository<Registration_PreferedCourses, Integer>{
    


 
}
