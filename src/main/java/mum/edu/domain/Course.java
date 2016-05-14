package mum.edu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	@Id @GeneratedValue
	private int courseId;
	private String courseCode;
	private String courseTitle;
	private String courseDescriptor;
	private String courseInstructor;
	private int courseCapacity;
	
	
	public Course(String courseCode, String courseTitle, String courseDescriptor, Course coursePrerequisite,
			String courseInstructor, int courseCapacity) {
		
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseDescriptor = courseDescriptor;
		this.courseInstructor = courseInstructor;
		this.courseCapacity = courseCapacity;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseDescriptor() {
		return courseDescriptor;
	}
	public void setCourseDescriptor(String courseDescriptor) {
		this.courseDescriptor = courseDescriptor;
	}
//	public Course getCoursePrerequisite() {
//		return coursePrerequisite;
//	}
//	public void setCoursePrerequisite(Course coursePrerequisite) {
//		this.coursePrerequisite = coursePrerequisite;
//	}
	public String getCourseInstructor() {
		return courseInstructor;
	}
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	public int getCourseCapacity() {
		return courseCapacity;
	}
	public void setCourseCapacity(int courseCapacity) {
		this.courseCapacity = courseCapacity;
	}
	
	
	
	

}
