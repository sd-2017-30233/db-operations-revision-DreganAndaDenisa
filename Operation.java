/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadata2;

/**
 *
 * @author Anda
 */
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.*;

import java.sql.*;
public class Operation {
    private Connection conn;
    
    public void addStudent(Student parsedStudent) {
		Integer student_id = parsedStudent.getStudentId();
		String student_name = parsedStudent.getStudentName();
                String student_date = parsedStudent.getStudentDate();
		String student_addr = parsedStudent.getStudentAddr();
		LogicControl studentSQL=new LogicControl(conn);
		studentSQL.createStudent(student_id,student_name,student_date,student_addr);
		
	}
	
	public void updateStudent(Student parsedStudent) {
		Integer student_id = parsedStudent.getStudentId();
		String student_addr = parsedStudent.getStudentAddr();
		LogicControl studentSQL=new LogicControl(conn);
		studentSQL.updateStudent(student_id, student_addr);
		
	}
	
	public void deleteStudent(Integer student_id) {
		LogicControl studentSQL=new LogicControl(conn);
		studentSQL.deleteStudent(student_id);
		
	}
        
        
        
         public void addCourse(Course parsedCourse) {
		Integer course_id = parsedCourse.getCourseId();
		String course_name = parsedCourse.getCourseName();
                String course_teacher = parsedCourse.getCourseTeacher();
		Integer course_year = parsedCourse.getCourseYear();
		LogicControl couSQL=new LogicControl(conn);
		couSQL.createCourse(course_id,course_name,course_teacher,course_year);
		
	}
	
	public void updateCourse(Course parsedCourse) {
		Integer course_id = parsedCourse.getCourseId();
		String course_teacher = parsedCourse.getCourseTeacher();
		LogicControl couSQL=new LogicControl(conn);
		couSQL.updateCourse(course_id, course_teacher);
		
	}
	
	public void deleteCourse(Integer course_id) {
		LogicControl couSQL=new LogicControl(conn);
		couSQL.deleteCourse(course_id);
		
	}
        
          public void enrolStudent(StudEnrol parsedStudent) {
		Integer student_id = parsedStudent.getStudentEnrolId();
		Integer course_id=parsedStudent.getCourseId();
		LogicControl studentEnrolSQL=new LogicControl(conn);
		studentEnrolSQL.enrolStudent(student_id,course_id);
		
	}
	
        
        public ArrayList<Student> getAllStudents() {
		ArrayList<Student> returnStatement = new ArrayList<Student>();
		LogicControl studentsSQL=new LogicControl(conn);
		returnStatement = studentsSQL.AllStudents();
		return returnStatement;
		
	}
        
          public ArrayList<Course> getAllCourses() {
		ArrayList<Course> returnStatement = new ArrayList<Course>();
		LogicControl coursesSQL=new LogicControl(conn);
		returnStatement = coursesSQL.AllCourses();
		return returnStatement;
		
	}
          
           public ArrayList<StudEnrol> getAllEnrolStud() {
		ArrayList<StudEnrol> returnStatement = new ArrayList<StudEnrol>();
		LogicControl studEnrolSQL=new LogicControl(conn);
		returnStatement = studEnrolSQL.AllEnrolStud();
		return returnStatement;
		
	}
        
    
}
