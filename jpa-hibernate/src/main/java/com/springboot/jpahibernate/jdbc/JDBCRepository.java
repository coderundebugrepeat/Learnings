package com.springboot.jpahibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.jpahibernate.entity.Course;

@Repository
public class JDBCRepository {
	
	@Autowired
	private JdbcTemplate springJDBCTemplate;

	private static String INSERT_QUERY = 
			"""
				insert into course (id,name,author)
				values (?,?,?);
			""";
	
	private static String DELETE_QUERY = 
			"""
				delete from course
				where id=?;
			""";
	
	private static String SELECT_QUERY = 
			"""
				select * from course
				where id=?;
			""";
	
	public void insert(Course course) {
		springJDBCTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJDBCTemplate.update(DELETE_QUERY,id);
	}
	
	public Course findById(long id) {
		//ResultSet->Bean=>RowMapper
		return springJDBCTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
