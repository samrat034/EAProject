package mum.edu.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Block {
	@Id 
	private Date startDate;
//	@OneToMany
//	private List<Course> courseList;
//	
//	
//	public List<Course> getCourseList() {
//		return courseList;
//	}
//	public void setCourseList(List<Course> courseList) {
//		this.courseList = courseList;
//	}
	
	
}
