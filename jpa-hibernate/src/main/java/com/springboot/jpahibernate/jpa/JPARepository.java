package com.springboot.jpahibernate.jpa;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.jpahibernate.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JPARepository {

	@PersistenceContext    //Can also use Autowired
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
	public Course findById(long id) {
		//ResultSet->Bean=>RowMapper
		return entityManager.find(Course.class, id);
	}
}
