package mum.edu.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.PendingCourseSwitch;
@Transactional(propagation=Propagation.MANDATORY)
public interface PendingCourseSwitchDAO extends JpaRepository<PendingCourseSwitch, Integer> {

	public List<PendingCourseSwitch> findByUser_Username(String username);

	public int countByUser_UsernameAndToCourse_Id(String username, int courseId);


}
