package com.jsp.SpringBoot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SpringBoot.DTO.Course;

public interface Course_Repo extends JpaRepository<Course, Integer>{

}
