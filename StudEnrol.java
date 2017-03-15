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
public class StudEnrol {
    private Integer studentEnrolId;
	private Integer studentId;
        private Integer courseId;
        
         //private DatabaseConnectionController conn=new DatabaseConnectionController();
	
	public Integer getStudentEnrolId() {
		return studentEnrolId;
	}
	public void setStudentEnrolId(Integer studentEnrolId) {
		this.studentEnrolId = studentEnrolId;
	}
        
        public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
        
        public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
        
        
}
