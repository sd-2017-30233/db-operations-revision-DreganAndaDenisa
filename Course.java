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
public class Course {
    private Integer courseId;
	private String courseName;
        private String teacher;
        private Integer year;
         //private DatabaseConnectionController conn=new DatabaseConnectionController();
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
        
        public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
        
           public String getCourseTeacher() {
		return teacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.teacher = courseTeacher;
	}
        
        public Integer getCourseYear() {
		return year;
	}
	public void setCourseYear(Integer year) {
		this.year = year;
	}
}
