package com.collegemangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemangement.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
