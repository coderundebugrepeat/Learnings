package com.springboot.jpahibernate.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.jpahibernate.entity.Course;

//Class to execute methods on startup of application

@Component
public class JPACommandLineRunner implements CommandLineRunner{

	@Autowired
	private JPARepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inserting using JPA");
		repository.insert(new Course(10,"Java","Shyam"));
		repository.insert(new Course(20,"AWS","Shyam"));
		repository.insert(new Course(30,"Azure","Shyam"));
		
		System.out.println("Delete using JPA");
		repository.deleteById(20);
		
		System.out.println("JPA Results :" +repository.findById(10));
		System.out.println("JPA Results :" +repository.findById(30));
	}

}
