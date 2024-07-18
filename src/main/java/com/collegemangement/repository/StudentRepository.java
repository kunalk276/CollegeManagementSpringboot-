package com.collegemangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemangement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
