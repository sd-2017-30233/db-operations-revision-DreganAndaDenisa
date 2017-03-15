/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anda
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import bazadata2.Student;
import bazadata2.Operation;
import bazadata2.Course;
import bazadata2.DatabaseConnectionController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class Tests {

	/**
	 * @throws java.lang.Exception
	 */
   
     private ResultSet resultSet;
     private DatabaseConnectionController conn=new DatabaseConnectionController();
	
     String statement = "SELECT * FROM STUDENT";
			PreparedStatement dbStatement;
			
	Course c1,c2,c3;
	Student s1, s2;
        Operation op;

 
	public void setUp() throws Exception {
		
            op=new Operation();
		c1=new Course();
                c2=new Course();
                c3=new Course();
                s1=new Student();
                s2=new Student();
          
		s1.setStudentId(1);
                s1.setStudentAddr("Cluj");
                s1.setStudentDate("13.08.1998");
                s1.setStudentName("Muresan");
                s2.setStudentId(2);
                c1.setCourseId(1);
                c2.setCourseId(2);
                c3.setCourseId(3);
		
		op.addStudent(s1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	
	public void tearDown() throws Exception {
            op=null;
		s1=null;
		
	}

	
	public void updateCourseTest() {
		assertTrue("fail", op.getAllStudents());
                
	}
	
	
	
	public void StudentOperationTest(){
		assertNotNull(s1.getStudentAddr());
		assertNull(s2.getStudentName());
	}

    private void assertTrue(String fail, ArrayList<Student> allStudents) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void assertNotNull(String studentAddr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void assertNull(String studentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
	
}


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}



