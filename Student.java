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

public class Student implements java.io.Serializable{

	private Integer studentId;
	private String studentName;
        private String birth;
        private String addr;
         //private DatabaseConnectionController conn=new DatabaseConnectionController();
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
        
        public String getStudentDate() {
		return birth;
	}
	public void setStudentDate(String bdate) {
		this.birth = bdate;
	}
        
        public String getStudentAddr() {
		return addr;
	}
	public void setStudentAddr(String addr) {
		this.addr =addr;
	}
}