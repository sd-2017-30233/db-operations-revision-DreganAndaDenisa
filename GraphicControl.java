/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadata2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.ResultSet;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Anda
 */
public class GraphicControl extends JFrame {
      private Statement statement;
     private ResultSet resultSet;
     private DatabaseConnectionController conn=new DatabaseConnectionController();
	private JPanel mainPanel;
        
        
        private JButton createStudent;
	private JButton updateStudent;
	private JButton deleteStudent;
        private JButton createCourse;
	private JButton updateCourse;
	private JButton deleteCourse;
        private JButton enrol;
        
        
        private JTextField studentId;
	private JTextField studentName;
	private JTextField studentDate;
	private JTextField studentAddr;
	private JTextField courseId;
	private JTextField courseName;
	private JTextField courseTeacher;
	private JTextField courseYear;
        
        private String[][] studentData ={};
	private String[][] courseData ={};
	private String[][] enrolData ={};
    
        private JTable studTable;
	private JTable couTable;
	private JTable enrolTable;
    
    private StudTable studTableModel = new StudTable(studentData);
	private CouTable courseTableModel = new CouTable(courseData);
	private StudEnrolTable enrolTableModel = new StudEnrolTable(enrolData);
        
        private java.util.List<Student> students = new ArrayList<Student>();
	private java.util.List<Course> courses = new ArrayList<Course>();
	private java.util.List<StudEnrol> enroll = new ArrayList<StudEnrol>();
	
        private LogicControl a;
        private String url = "jdbc:mysql://localhost:3306/tema";
	private	String uid = "root";
	private	String pw = "";
        private Integer pw1=0;
	private BufferedReader reader;
	private Connection connection;
        
         
GraphicControl() {


        // try {
             a = new LogicControl(DatabaseConnectionController.getConnection());
                 
        //} catch (SQLException ex) {
         //    Logger.getLogger(GraphicController.class.getName()).log(Level.SEVERE, null, ex);
        // }
 this.setTitle("Students-Courses");
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1000, 450));
		mainPanel = new JPanel();
		mainPanel.setVisible(true);

		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(Color.pink);
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(5, 10, 5, 10);
        
                enrol = new JButton("Enrol");
                enrol.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 2;
		constraint.gridy = 8;
		constraint.gridwidth = 1;
		mainPanel.add(enrol, constraint);
                
        createStudent = new JButton("Creare Student");
                createStudent.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		createStudent.addActionListener(new GraphicControl.Control());
		constraint.gridx = 3;
		constraint.gridy = 8;
		constraint.gridwidth = 1;
		mainPanel.add(createStudent, constraint);
                
                updateStudent = new JButton("Actual Student");
                updateStudent.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		updateStudent.addActionListener(new GraphicControl.Control());
		constraint.gridx = 4;
		constraint.gridy = 8;
		constraint.gridwidth = 1;
		mainPanel.add(updateStudent, constraint);
                
                updateStudent = new JButton("Actual Student");
                updateStudent.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		updateStudent.addActionListener(new GraphicControl.Control());
		constraint.gridx = 5;
		constraint.gridy = 8;
		constraint.gridwidth = 1;
		mainPanel.add(updateStudent, constraint);
                
                deleteStudent = new JButton("Sterge Student");
                deleteStudent.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		deleteStudent.addActionListener(new GraphicControl.Control());
		constraint.gridx = 6;
		constraint.gridy = 8;
		constraint.gridwidth = 1;
		mainPanel.add(deleteStudent, constraint);
                
                studentId = new JTextField();
		studentId.setText("IDStu");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 0;
		constraint.gridy = 5;
		constraint.gridwidth = 1;
		mainPanel.add(studentId, constraint);
                
                 studentName = new JTextField();
		studentName.setText("NameStu");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 1;
		constraint.gridy = 5;
		constraint.gridwidth = 1;
		mainPanel.add(studentName, constraint);
                
                 studentDate = new JTextField();
		studentDate.setText("DateStu");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 2;
		constraint.gridy = 5;
		constraint.gridwidth = 1;
		mainPanel.add(studentDate, constraint);
                
                 studentAddr = new JTextField();
		studentAddr.setText("AddrStu");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 3;
		constraint.gridy = 5;
		constraint.gridwidth = 1;
		mainPanel.add(studentAddr, constraint);
        
                createCourse = new JButton("Creare Curs");
                createCourse.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		createCourse.addActionListener(new GraphicControl.Control());
		constraint.gridx =4;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		mainPanel.add(createCourse, constraint);
		
		updateCourse = new JButton("Actual. Curs");
                updateCourse.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		updateCourse.addActionListener(new GraphicControl.Control());
		constraint.gridx = 5;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		mainPanel.add(updateCourse, constraint);
		
		deleteCourse = new JButton("Sterge Curs");
                deleteCourse.setBackground(Color.red);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 6;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		mainPanel.add(deleteCourse, constraint);
                
                courseId = new JTextField();
		courseId.setText("IDCurs");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		mainPanel.add(courseId, constraint);
		
		courseName = new JTextField();
		courseName.setText("NumeCurs");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 1;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		mainPanel.add(courseName, constraint);
		
		courseTeacher = new JTextField();
		courseTeacher.setText("ProfCurs");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 2;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		mainPanel.add(courseTeacher, constraint);
                
                courseYear = new JTextField();
		courseYear.setText("AnCurs");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 3;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		mainPanel.add(courseYear, constraint);
                
                
                studTable = new JTable(studTableModel);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 4;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		JScrollPane scrollPaneC = new JScrollPane(studTable);
		studTable.getTableHeader().setReorderingAllowed(false);
                studTable.setBackground(Color.lightGray);
		studTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		mainPanel.add(scrollPaneC,constraint);
                
                couTable = new JTable(courseTableModel);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 1;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		JScrollPane scrollPanes = new JScrollPane(couTable);
		couTable.getTableHeader().setReorderingAllowed(false);
                couTable.setBackground(Color.lightGray);
		couTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		mainPanel.add(scrollPanes,constraint);
		
              /*   enrolTable = new JTable(enrolTableModel);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 7;
		constraint.gridy = 6;
		constraint.gridwidth = 1;
		JScrollPane scrollPanee = new JScrollPane(enrolTable);
		enrolTable.getTableHeader().setReorderingAllowed(false);
                enrolTable.setBackground(Color.lightGray);
		enrolTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		mainPanel.add(scrollPanee,constraint);*/
                
                
		
                mainPanel.setVisible(true);
		this.setResizable(false);
		this.add(mainPanel, BorderLayout.PAGE_START);
		this.pack();
		updateTableStudents();
		updateTableCourses();
                
}
                public void updateTableStudents()  { 
		Operation op = new Operation();
		this.students = op.getAllStudents();
		int size = students.size();
		String[][] row = new String[size+2][6];
		for(int line=0;line<size;line++){
			String c0 = students.get(line).getStudentId().toString();
			String c1 = students.get(line).getStudentName();
			String c2 = students.get(line).getStudentDate();
                        String c3=students.get(line).getStudentAddr();

			row[line][0] = c0;
			row[line][1] = c1;
			row[line][2] = c2;
                        row[line][3]=c3;
		}
		this.studentData = row;
		this.studTableModel.setData(row);
		this.repaint();

	}
                
                 public void updateTableCourses()  { 
		Operation op = new Operation();
		this.courses = op.getAllCourses();
		int size = courses.size();
		String[][] row = new String[size+2][6];
		for(int line=0;line<size;line++){
			String c0 = courses.get(line).getCourseId().toString();
			String c1 = courses.get(line).getCourseName();
			String c2 = courses.get(line).getCourseTeacher();
                        String c3=courses.get(line).getCourseYear().toString();

			row[line][0] = c0;
			row[line][1] = c1;
			row[line][2] = c2;
                        row[line][3]=c3;
		}
		this.courseData = row;
		this.courseTableModel.setData(row);
		this.repaint();

	}
                 
                  public void updateTableEnrol()  { 
		Operation op = new Operation();
		this.enroll = op.getAllEnrolStud();
		int size = enroll.size();
		String[][] row = new String[size+2][6];
		for(int line=0;line<size;line++){
			String c0 = enroll.get(line).getStudentEnrolId().toString();;
                        String c1=enroll.get(line).getCourseId().toString();

			row[line][0] = c0;
			row[line][1] = c1;
		
		}
		this.courseData = row;
		this.courseTableModel.setData(row);
		this.repaint();

	}
        
                 
                 public class Control implements ActionListener  {

		private Integer selectFlag = 0;
		private Operation operations = new Operation();
		
		@Override
		public void actionPerformed(ActionEvent e)  {
			
                    if (e.getSource() == enrol) {
				Integer student_id = Integer.parseInt(studentId.getText());
				Integer course_id = Integer.parseInt(courseId.getText());
                                
				StudEnrol parsedEnrolStudent = new StudEnrol();
				parsedEnrolStudent.setStudentEnrolId(student_id);
				parsedEnrolStudent.setCourseId(course_id);
                                
				operations.enrolStudent(parsedEnrolStudent);
				updateTableStudents();
				updateTableCourses();
                    }
                    
			if (e.getSource() == createStudent) {
				Integer student_id = Integer.parseInt(studentId.getText());
				String student_name = studentName.getText();
                                String student_date = studentDate.getText();
                                String student_addr = studentAddr.getText();
                                
				Student parsedStudent = new Student();
				parsedStudent.setStudentId(student_id);
				parsedStudent.setStudentName(student_name);
                                parsedStudent.setStudentDate(student_date);
				parsedStudent.setStudentAddr(student_addr);
                                
				operations.addStudent(parsedStudent);
				updateTableStudents();
				updateTableCourses();
				       
} 
      
                        if (e.getSource() == updateStudent) {
				Integer student_id = Integer.parseInt(studentId.getText());
                                String student_addr = studentAddr.getText();
                                
				Student parsedStudent = new Student();
				parsedStudent.setStudentId(student_id);
				parsedStudent.setStudentAddr(student_addr);
                                
				operations.updateStudent(parsedStudent);
				updateTableStudents();
				updateTableCourses();
				       
} 
       if (e.getSource() == deleteStudent) {
				Integer student_id = Integer.parseInt(studentId.getText());
                                
				operations.deleteStudent(student_id);
                                
                                
				updateTableStudents();
				updateTableCourses();
       }
                     
       
                        if (e.getSource() == createCourse) {
				Integer course_id = Integer.parseInt(courseId.getText());
				String course_name = courseName.getText();
                                String course_teacher = courseTeacher.getText();
                                Integer course_year = Integer.parseInt(courseYear.getText());
                                
				Course parsedCourse = new Course();
				parsedCourse.setCourseId(course_id);
				parsedCourse.setCourseName(course_name);
                                parsedCourse.setCourseTeacher(course_teacher);
				parsedCourse.setCourseYear(course_year);
                                
				operations.addCourse(parsedCourse);
				updateTableStudents();
				updateTableCourses();
				       
} 
      
                        if (e.getSource() == updateCourse) {
				Integer course_id = Integer.parseInt(courseId.getText());
                                String course_teacher = courseTeacher.getText();
                                
				Course parsedCourse = new Course();
				parsedCourse.setCourseId(course_id);
				parsedCourse.setCourseTeacher(course_teacher);
                                
				operations.updateCourse(parsedCourse);
				updateTableStudents();
				updateTableCourses();
				       
} 
                               if (e.getSource() == deleteCourse) {
				Integer course_id = Integer.parseInt(courseId.getText());
                                
				operations.deleteCourse(course_id);
                                
                                
				updateTableStudents();
				updateTableCourses();
       }
}
                 }
}
