package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring JDBC Project is getting started" );
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml"); this is for xml based configuration
        ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        //inserting student type 1
		/*
		 * JdbcTemplate template = context.getBean("JdbcTemplate",JdbcTemplate.class);
		 * 
		 * String
		 * query="insert into student_details_orm(student_id,student_city,student_name) values(?,?,?)"; 
		 * int result= template.update(query,123,"Sumit Kumar","Bihar");
		 * System.out.println("Number of record inserted"+result);
		 */
        
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class); 
        
        //inserting student type 2
		/*
		 * Student student= new Student(); 
		 * student.setId(12345);
		 * student.setCity("Bihar Sitamarhi"); 
		 * student.setName("Chandra Kumar");
		 * 
		 * int result=studentDao.insert(student);
		 * System.out.println("Student added"+result);
		 */
        
        //updating student
		/*
		 * Student student=new Student(); 
		 * student.setId(12345);
		 * student.setCity("Sitamarhi"); 
		 * student.setName("Amit");
		 * 
		 * int result= studentDao.change(student);
		 * System.out.println("Student update"+result);
		 */
        
        //deleting student
		/*
		 * int result= studentDao.delete(123);
		 * System.out.println("Student deleted"+result);
		 */
        
        //get student
		/*
		 * Student student = studentDao.getStudent(12345);
		 * System.out.println(student.getName()+student.getCity());
		 */
        
        //get all student
		
		  List<Student> student = studentDao.getAllStudent(); 
		  for(Student s:student) {
		  System.out.println(s.getId()+s.getName()+s.getCity()); }
		 
        
        
        
    }
}
