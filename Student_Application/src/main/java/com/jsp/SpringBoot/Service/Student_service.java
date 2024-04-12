package com.jsp.SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.SpringBoot.DAO.Student_dao;
import com.jsp.SpringBoot.DTO.Student_details;
import com.jsp.SpringBoot.util_package.Respons_Structure;

@Service
public class Student_service {
	
	@Autowired
	private Student_dao student_dao;

	public ResponseEntity<Respons_Structure<Student_details>> saveStudent(Student_details s) {
		Respons_Structure<Student_details> responsive=new Respons_Structure<Student_details>();
		responsive.setStatus(HttpStatus.CREATED.value());
		responsive.setMessage("Create Student_details data save successfully");
		responsive.setData(student_dao.saveStudent(s));
		
		ResponseEntity<Respons_Structure<Student_details>>entity=new 
				ResponseEntity<>(responsive,HttpStatus.CREATED);
		return entity;
	}

	public ResponseEntity<Respons_Structure<Student_details>> fetchById(int id) {
		Respons_Structure<Student_details> responsive =new Respons_Structure<Student_details>();
		responsive.setStatus(HttpStatus.OK.value());
		responsive.setMessage("fetchById recive data successfully");
		responsive.setData( student_dao.fetchById(id));
		
		ResponseEntity<Respons_Structure<Student_details>> entity=new
				ResponseEntity<Respons_Structure<Student_details>>(responsive,HttpStatus.OK);
		return entity;
	}
	
	public ResponseEntity<Respons_Structure<Student_details>> fetchByName(String name) {
		Respons_Structure<Student_details> responsive =new Respons_Structure<Student_details>();
		responsive.setStatus(HttpStatus.OK.value());
		responsive.setMessage("fetchByName recive data successfully");
		responsive.setData( student_dao.fetchByName(name));
		
		ResponseEntity<Respons_Structure<Student_details>> entity=new
				ResponseEntity<Respons_Structure<Student_details>>(responsive,HttpStatus.OK);
		return entity;
	}
		
	public ResponseEntity<Respons_Structure<List<Student_details>>>fetchAll(){
		Respons_Structure<List<Student_details>> responsive=new Respons_Structure<List<Student_details>>();
		responsive.setStatus(HttpStatus.OK.value());
		responsive.setMessage("FetchAll the data recived successfull");
		responsive.setData(student_dao.fetchAll());
		
		ResponseEntity<Respons_Structure<List<Student_details>>> entity=new 
				ResponseEntity<Respons_Structure<List<Student_details>>>(responsive,HttpStatus.OK);
		
		return entity;
	}
	
	public ResponseEntity<Respons_Structure<Student_details>> update(int id,Student_details s){
		Student_details sd=student_dao.fetchById(id);
		Respons_Structure<Student_details>responsive=new Respons_Structure<Student_details>();

			if(sd !=null) {
				s.setId(id);  
				responsive.setStatus(HttpStatus.OK.value());
				responsive.setMessage("student_details data update success");
				responsive.setData(student_dao.update(s));
				
				ResponseEntity<Respons_Structure<Student_details>> entity=new 
						ResponseEntity<Respons_Structure<Student_details>>(responsive,HttpStatus.OK);
					
					return entity;
			}
		return null;
	}

	public ResponseEntity<Respons_Structure<String>> deleteById(int id) {
		Respons_Structure<String> responsive=new Respons_Structure<>();
		responsive.setStatus(HttpStatus.OK.value());
		responsive.setMessage("Student_details deletebyid data successfull");
		responsive.setData(student_dao.deletById(id));
		
		ResponseEntity<Respons_Structure<String>> entity=new 
			ResponseEntity<Respons_Structure<String>>(responsive,HttpStatus.OK);
		
		return entity;
	}

	public ResponseEntity<Respons_Structure<String>> deleteAll() {
		Respons_Structure<String> responsive=new Respons_Structure<>();
		responsive.setStatus(HttpStatus.OK.value());
		responsive.setMessage("Student_details deletebyid data successfull");
		responsive.setData(student_dao.deletAll());
		
		ResponseEntity<Respons_Structure<String>> entity=new 
			ResponseEntity<Respons_Structure<String>>(responsive,HttpStatus.OK);
		
		return entity;
	}

}
