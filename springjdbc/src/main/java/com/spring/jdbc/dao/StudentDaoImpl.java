package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		// TODO Auto-generated method stub
		 String query="insert into student_details_orm(student_id,student_city,student_name) values(?,?,?)";
		 int r=this.jdbcTemplate.update(query,student.getId(),student.getCity(),student.getName());
		 return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int change(Student student) {
		// TODO Auto-generated method stub
		String query="update student_details_orm set student_name=?, student_city=? where student_id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}

	public int delete(int studentId) {
		// TODO Auto-generated method stub
		String query="delete from student_details_orm where student_id=?";
		int r= this.jdbcTemplate.update(query,studentId);
		return r;
	}

	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		String query="select * from student_details_orm where student_id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String query="select * from student_details_orm";
		List<Student> student=this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}
	
	

}
