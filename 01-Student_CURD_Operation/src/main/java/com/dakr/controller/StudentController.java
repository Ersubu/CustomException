package com.dakr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.customException.BusinessException;
import com.dakr.customException.ControllerException;
import com.dakr.entity.StudentEntity;
import com.dakr.repository.StudentRepository;
import com.dakr.service.StudentServiceImpl;

@RestController
public class StudentController {
	@Autowired
	private StudentServiceImpl Service;

	@Autowired
	private StudentRepository stdRepo;

	@PostMapping("/save")
	public ResponseEntity<?> insertStud(@RequestBody StudentEntity std) {
		try {
			StudentEntity s1 = Service.saveStudent(std);
			return new ResponseEntity<StudentEntity>(s1, HttpStatus.BAD_REQUEST);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessege());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("610", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	// for retrive data from db

	@GetMapping("/getOne/{stdId}")
	public ResponseEntity<?> getOne(@PathVariable Integer stdId) {
		try {
		StudentEntity s2 = Service.getStudent(stdId);
		return new ResponseEntity<StudentEntity>(s2, HttpStatus.BAD_REQUEST);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessege());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("61", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/retrive")
	public Optional<StudentEntity> retriveData(@RequestParam Integer id) {
		return Service.retrive(id);

	}

	// retrive with like operator
	@GetMapping("/getByName/{course}")
	public List<StudentEntity> findbycourse(@PathVariable String course) {
		return stdRepo.findByCourseName("%" + course + "%");

	}

	@GetMapping("/getCourseName/{name}")
	public List<StudentEntity> getByName(@PathVariable String name) {
		return stdRepo.findBystdName("%" + name + "%");

	}

	// for retrieve all data from

	@GetMapping("/retriveAll")
	public List<StudentEntity> retriveAll() {
		return Service.retriveAll();
	}

	@GetMapping("/getall")
	public List<StudentEntity> getAll() {
		List<StudentEntity> s3 = Service.getAllStudent();
		return s3;
	}

	// for update data from database
	@PutMapping("/update")
	public StudentEntity updateData(@RequestBody StudentEntity reg) {
		return Service.updateD(reg);
	}

	// for delete data from database
	@DeleteMapping("/delete")
	public String deleteData(@RequestParam Integer id) {
		return Service.deleteD(id);
	}

	@DeleteMapping("/deleteone/{stdId}")
	public void deleteOne(@PathVariable Integer stdId) {
		Service.deleteStudent(stdId);

	}

	@DeleteMapping("/deleteall")
	public void deleteAllStudents() {
		Service.deleteAllStudent();

	}

}
