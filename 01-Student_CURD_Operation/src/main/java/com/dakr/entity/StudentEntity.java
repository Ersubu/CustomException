package com.dakr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="std_Details")
public class StudentEntity {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stdId;
    private String stdName;
    private String courseName;
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "StudentEntity [stdId=" + stdId + ", stdName=" + stdName + ", courseName=" + courseName + "]";
	}
    
    
    
	
	

}
