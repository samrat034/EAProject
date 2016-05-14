package mum.edu.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

@Transactional
public class CourseDAO {
	SessionFactory sessionFactory;
	
	public CourseDAO(SessionFactory sessionFactory){
		this.sessionFactory =  sessionFactory;
	}
	
}
