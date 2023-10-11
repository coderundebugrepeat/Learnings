package com.springboot.jpahibernate.spring.datajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpahibernate.entity.Course;

public interface SpringDataJPARepository extends JpaRepository<Course,Long>{
	
	//Custome method findBy appended by field name camel cased
	List<Course> findByAuthor(String author);
}
