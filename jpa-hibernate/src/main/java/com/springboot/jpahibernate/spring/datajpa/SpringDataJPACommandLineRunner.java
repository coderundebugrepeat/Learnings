package com.springboot.jpahibernate.spring.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.jpahibernate.entity.Course;

//Class to execute methods on startup of application

@Component
public class SpringDataJPACommandLineRunner implements CommandLineRunner{

	@Autowired
	private SpringDataJPARepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inserting using Spring Data JPA");
		repository.save(new Course(100,"Java","Shyam"));
		repository.save(new Course(200,"AWS","Shyam"));
		repository.save(new Course(300,"Azure","Shyam"));
		
		System.out.println("Delete using Spring Data JPA");
		repository.deleteById(200L);
		
		System.out.println("Spring Data JPA Results :" +repository.findById(100L));
		System.out.println("Spring Data JPA Results :" +repository.findById(300L));
		
		System.out.println("Spring Data JPA Results findAll:" +repository.findAll());
		System.out.println("Spring Data JPA Results Count:" +repository.count());
		
		System.out.println("Spring Data JPA Results findByAuthor:" +repository.findByAuthor("Shyam"));
	}

}
