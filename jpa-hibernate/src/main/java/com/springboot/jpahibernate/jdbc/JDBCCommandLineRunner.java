package com.springboot.jpahibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.jpahibernate.entity.Course;

//Class to execute methods on startup of application

@Component
public class JDBCCommandLineRunner implements CommandLineRunner{

	@Autowired
	private JDBCRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inserting using JDBCTemplate");
		repository.insert(new Course(1,"Java","Shyam"));
		repository.insert(new Course(2,"AWS","Shyam"));
		repository.insert(new Course(3,"Azure","Shyam"));
		
		System.out.println("Deleting using JDBCTemplate");
		repository.deleteById(2);
		
		System.out.println("JDBCTemplate results :" +repository.findById(1));
		System.out.println("JDBCTemplate results :" +repository.findById(3));
	}

}
