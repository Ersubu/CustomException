package com.dakr.service;

import java.util.List;
import java.util.Optional;


import com.dakr.entity.StudentEntity;

public interface SudentService {

	StudentEntity saveStudent(StudentEntity std);
	
	   public Optional<StudentEntity> retrive(Integer id);
	   public StudentEntity getStudent(Integer stdId);

		public List<StudentEntity> retriveAll();
		
		public List<StudentEntity> getAllStudent();

		public StudentEntity updateD(StudentEntity reg);

		public String deleteD(Integer id);
		public void deleteStudent(Integer stdId);
		public void deleteAllStudent();

		//public StudentEntity insert(StudentEntity re);

}
