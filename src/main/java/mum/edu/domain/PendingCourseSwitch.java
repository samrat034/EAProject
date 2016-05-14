package mum.edu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PendingCourseSwitch {

    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Registration fromRegistration;
    
    @ManyToOne
    private Course toCourse;
    private boolean isSwap;
	public PendingCourseSwitch() {
		
	}
	public PendingCourseSwitch(User user, Registration fromRegistration, Course toCourse, boolean isSwap) {
		super();
		this.user = user;
		this.fromRegistration = fromRegistration;
		this.toCourse = toCourse;
		this.isSwap = isSwap;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Registration getFromRegistration() {
		return fromRegistration;
	}
	public void setFromRegistration(Registration fromRegistration) {
		this.fromRegistration = fromRegistration;
	}
	public Course getToCourse() {
		return toCourse;
	}
	public void setToCourse(Course toCourse) {
		this.toCourse = toCourse;
	}
	public boolean isSwap() {
		return isSwap;
	}
	public void setSwap(boolean isSwap) {
		this.isSwap = isSwap;
	}

}
