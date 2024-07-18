package com.collegemangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegemangement.entity.Courses;
import com.collegemangement.service.CoursesService;

@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @PostMapping("/Courses/add")
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course) {
        Courses savedCourse = coursesService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    @PutMapping("/Courses/{id}")
    public ResponseEntity<Courses> updateCourse(@PathVariable int id, @RequestBody Courses course) {
        course.setCid(id);
        Courses updatedCourse = coursesService.updateCourse(course);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/Courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        coursesService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Courses/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable int id) {
        Courses course = coursesService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<java.util.List<Courses>> getAllCourses() {
        java.util.List<Courses> coursesList = coursesService.getAllCourses();
        return ResponseEntity.ok(coursesList);
    }
}
