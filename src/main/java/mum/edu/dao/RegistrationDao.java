package mum.edu.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Course;
import mum.edu.domain.Registration;
@Transactional(propagation=Propagation.MANDATORY)
@Repository
public interface RegistrationDao extends JpaRepository<Registration,Integer>  {

     public List<Registration> findByUser_UsernameAndBlockStartDateGreaterThan(String username, Date blockStartDate);


     @Query("select distinct pc from Registration r join r.preferedCourses pc where r.user.username = ?1 and r.block.id = ?2")
     public List<Course> findByUser_UsernameAndBlock_Id(String username, int blockId);
     
     public List<Registration> findByBlock_Id(int blockId);
     
     public List<Registration> findByUser_Username(String username);
     
     public List<Registration> findByCourse_Id(int courseId);
     

     @Query("select count(distinct r) from Registration r join r.preferedCourses pc where r.block.id = ?1 and pc.id = ?2)")
     public int countByBlock_IdAndPreferedCourse_Id(int blockId, int preferedCourseId);

     
     
     public int countByCourse_Id(int courseId);
     
    
     @Query("select distinct r from Registration r join r.preferedCourses pc where r.block.id = ?1 and r.course.id = ?2 and pc.id = ?3")
     public Registration findByBlockIdAndCourse_IdPreferedCourse_Id(int blockId, int courseId, int preferedCourseId);

}
