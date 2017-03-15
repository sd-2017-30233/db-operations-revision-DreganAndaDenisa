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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LogicControl {
  private Connection conn;
  private CallableStatement statement;
  private ResultSet resultSet;
 // private CallableStatement callableStatement;

  public LogicControl(Connection connection) {
    this.conn = DatabaseConnectionController.getConnection();
  }

	public ArrayList<Student> AllStudents(){

		ArrayList<Student> returnStatement = new ArrayList<Student>();

		try {

			String statement = "SELECT * FROM STUDENT";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
				Integer student_id = rs.getInt("ids");
				String student_name = rs.getString("namee");
                                 String birth=rs.getString("birth_date");
                                 String addr=rs.getString("adresa");
				Student newStudent = new Student();
				newStudent.setStudentId(student_id);
				newStudent.setStudentName(student_name);
                                newStudent.setStudentDate(birth);
				newStudent.setStudentAddr(addr);
				returnStatement.add(newStudent);			
			}
		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}

		return returnStatement;
		
	}


	public void createStudent(Integer ids,String namee,String birth_date,String adresa) {

		try {

			String statement = "INSERT INTO `student` (`ids`,`namee`,`birth_date`,`adresa`) VALUES (?,?,?,?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
                        dbStatement.setInt(1,ids);
			dbStatement.setString(2,namee);
                        dbStatement.setString(3,birth_date);
                        dbStatement.setString(4,adresa);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void updateStudent(Integer ids, String adresa) {

		try {

			String statement = "UPDATE STUDENT SET adresa=? where ids=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1,adresa );
			dbStatement.setInt(2,ids );
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void deleteStudent(Integer ids) {

		try {

			String statement = "DELETE FROM STUDENT where ids=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, ids);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}
	}
        
        
        
        
        	public ArrayList<Course> AllCourses(){

		ArrayList<Course> returnStatement = new ArrayList<Course>();

		try {

			String statement = "SELECT * FROM COURSES";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
				Integer course_id = rs.getInt("idc");
				String course_name = rs.getString("namec");
                                 String teacher=rs.getString("teacher");
                                 Integer year=rs.getInt("study_year");
				Course newCourse = new Course();
				newCourse.setCourseId(course_id);
				newCourse.setCourseName(course_name);
                                newCourse.setCourseTeacher(teacher);
				newCourse.setCourseYear(year);
				returnStatement.add(newCourse);			
			}
		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}

		return returnStatement;
		
	}


	public void createCourse(Integer idc,String namec,String teacher,Integer year) {
            
		try {

			String statement = "INSERT INTO `COURSES` (`idc`,`namec`,`teacher`,`study_year`) VALUES (?,?,?,?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
                        dbStatement.setInt(1,idc);
			dbStatement.setString(2,namec);
                        dbStatement.setString(3,teacher);
                        dbStatement.setInt(4,year);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void updateCourse(Integer ids, String teacher) {

		try {

			String statement = "UPDATE COURSES SET teacher=? where idc=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1,teacher );
			dbStatement.setInt(2,ids );
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void deleteCourse(Integer idc) {

		try {
String statementt="SET FOREIGN_KEY_CHECKS=0";
PreparedStatement dbStatementt = conn.prepareStatement(statementt);
			dbStatementt.executeQuery();


			String statement = "DELETE FROM COURSES where idc=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, idc);
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}
	}
        
        
        public ArrayList<StudEnrol> AllEnrolStud(){

		ArrayList<StudEnrol> returnStatement = new ArrayList<StudEnrol>();

		try {

			String statement = "SELECT * FROM STUDENT_ENROL";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

			while(rs.next()) {
				Integer course_id = rs.getInt("idc");
                                 Integer student_id=rs.getInt("ids");
				StudEnrol newEnrol = new StudEnrol();
				newEnrol.setCourseId(course_id);
				newEnrol.setStudentId(student_id);
                               
				returnStatement.add(newEnrol);			
			}
		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
			
		}

		return returnStatement;
		
	}
        
     public void enrolStudent(Integer ids,Integer idc) {

		try {

			String statement = "INSERT INTO `STUDENT_ENROL` (`ids`,`idc`) VALUES (?,?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
                        dbStatement.setInt(1,ids);
                        dbStatement.setInt(2,idc);
			
			dbStatement.executeUpdate();

		}
		catch(SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
			//System.out.println("SQLState: " + e.getSQLState());
		}
	}
        
    

        
}
