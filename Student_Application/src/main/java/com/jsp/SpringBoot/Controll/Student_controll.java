package com.jsp.SpringBoot.Controll;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController ;

import com.jsp.SpringBoot.DTO.Student_details;
import com.jsp.SpringBoot.Service.Student_service;
import com.jsp.SpringBoot.util_package.Respons_Structure;

@RestController
public class Student_controll {
	
	@Autowired
	private Student_service student_service;
	
	@PostMapping("/save")
	public ResponseEntity<Respons_Structure<Student_details>>saveResponseEntity(@RequestBody Student_details s){
		return student_service.saveStudent(s);
	}
	
	@GetMapping("/fetchById")
	public  ResponseEntity<Respons_Structure<Student_details>>fetchByIdResponseEntity(@RequestParam int id){
		return student_service.fetchById(id);	
	}
	
	@GetMapping("/fetchByName")
	public  ResponseEntity<Respons_Structure<Student_details>>fetchByNameResponseEntity(@RequestParam String name){
		return student_service.fetchByName(name);	
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<Respons_Structure<List<Student_details>>>fetchAllResponseEntity(){
		return student_service.fetchAll();
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<Respons_Structure<Student_details>>updateResponseEntity(@PathVariable int id,@RequestBody Student_details s){
		
		return student_service.update(id, s);	
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<Respons_Structure<String>>deleteById(@RequestParam int id){
		return student_service.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<Respons_Structure<String>>deleteAll(){
		return student_service.deleteAll();
	}
}
