package com.dakr.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.customException.BusinessException;
import com.dakr.entity.StudentEntity;
import com.dakr.repository.StudentRepository;
@Service
public class StudentServiceImpl implements SudentService {
	
	@Autowired
	private StudentRepository repo;
	
  @Override
	public StudentEntity saveStudent(StudentEntity std) {
	  if(std.getStdName().isEmpty()||std.getStdName().length()==0) {
			  throw new BusinessException("601","please send proper name its blank");
		  }
  try { StudentEntity std1=repo.save(std);
	     return std1;
	  }catch(IllegalArgumentException e ){
	    	 throw new BusinessException("602","given student is null"+e.getMessage());
	    	 
	     }
	  catch(Exception e ){
	    	 throw new BusinessException("603","something went wrong in service layer"+e.getMessage());
	    	 
	     }
		  
	  }
  
  @Override
	public StudentEntity getStudent(Integer stdId) {
		try {
		return repo.findById(stdId).get();
		}catch(IllegalArgumentException e ){
	    	 throw new BusinessException("611","given student id  is null, please enter a given id"+e.getMessage());
	    	 
	     }
         catch(NoSuchElementException e){
	    	 throw new BusinessException("612","given employee id is not available in Database"+e.getMessage());
	    	 
	     }
	}
	
  @Override
	public Optional<StudentEntity> retrive(Integer id) {
      try {
    	  return repo.findById(id);
      }catch(IllegalArgumentException e ){
	    	 throw new BusinessException("604","given student id  is null, please enter a given id"+e.getMessage());
	    	 
	     }
          catch(NoSuchElementException e){
	    	 throw new BusinessException("605","given employee id is not available in Database"+e.getMessage());
	    	 
	     }
		
	}

	@Override
	public List<StudentEntity> retriveAll() {
		List<StudentEntity> std4=null;
		try {
            std4=repo.findAll();
		}catch(Exception e) {
			throw new BusinessException("607","something went in service layer while fetching the data"+e.getMessage());
			
		}
          if(std4.isEmpty())
       	   throw new BusinessException("606","Hey list is complerely empty , we have nothig to return");
		    return std4;
		
	}
	
	
	
	@Override
	public void deleteStudent(Integer stdId) {
		try {
		  repo.deleteById(stdId);
		}
		catch(IllegalArgumentException e ){
	    	 throw new BusinessException("608","given student id  is null, please enter a given id"+e.getMessage());
	    	 
	     }
		
	}
	
	
	public StudentEntity updateD(StudentEntity re) {
		return repo.save(re);
	}

	@Override
	public String deleteD(Integer id) {
		String temp = "";
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			temp = "deleted successfully....";
		} else {
			temp = id + "is not present in the Data Base";
		}
		return temp;
	}

	

	@Override
	public List<StudentEntity> getAllStudent() {
		
		return repo.findAll();
	}

	

	@Override
	public void deleteAllStudent() {
		repo.deleteAll();
		
		
	}

	

}
