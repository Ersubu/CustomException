package com.dakr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	
	public  List<StudentEntity> findByCourseName(String stdName);
	   List<StudentEntity> findBystdName(String stdName);

}
