package com.jsp.SpringBoot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SpringBoot.DTO.Student_details;

public interface Student_Repo extends JpaRepository<Student_details, Integer>{

	Student_details findByName(String name);

	
}