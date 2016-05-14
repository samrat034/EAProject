package mum.edu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Registration {
	@Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Block block;

    @OneToMany(mappedBy = "registration")
    private List<Registration_PreferedCourses> preferedCourses = new ArrayList<Registration_PreferedCourses>();

	public Registration() {
		
	}

	public Registration(User user, Course course, Block block) {
		
		this.user = user;
		this.course = course;
		this.block = block;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public List<Registration_PreferedCourses> getPreferedCourses() {
		return preferedCourses;
	}

	public void setPreferedCourses(List<Registration_PreferedCourses> preferedCourses) {
		this.preferedCourses = preferedCourses;
	}


}
