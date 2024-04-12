package com.jsp.SpringBoot.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.SpringBoot.DTO.Student_details;
import com.jsp.SpringBoot.Repo.Student_Repo;

@Repository
public  class Student_dao {
	
	@Autowired
	Student_Repo student_Repo;
	
	public Student_details saveStudent(Student_details s) {
		return student_Repo.save(s);
	}
	
	public List<Student_details> fetchAll(){
		return student_Repo.findAll();
	}
	
	public Student_details fetchById(int id) {
		Optional<Student_details> op=student_Repo.findById(id);
			
		if(op.isPresent()) {
			System.out.println(op.get());
			return op.get();
		}else {
			return  null;
		}	
	}
	
	public String deletById(int id) {
		student_Repo.deleteById(id);
		return "delete";
	}
	
	public String deletAll() {
		student_Repo.deleteAll();
		return deletAll();
		
	}
	
	public Student_details update(Student_details s) {
		return student_Repo.save(s);
	}

	public Student_details fetchByName(String name) {
		return student_Repo.findByName(name);
	}

}
