package com.collegemangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemangement.entity.Student;
import com.collegemangement.entity.Teacher;
import com.collegemangement.service.StudentService;
import com.collegemangement.service.TeacherService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
    private StudentService sservice;  // tservice is reference of studentService 

	//path in postman to post data ---> http://localhost:8080/Student/addStudent
    @PostMapping("/Student/addStudent")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
    	Student savedStudent = sservice.addStudent(student);
    	return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
	
	

    //path in postman to get data --->  http://localhost:8080/Student/get/1
    @GetMapping("/Student/get/{sid}")
    public ResponseEntity<Student> getStudentDetail(@PathVariable ("sid") int sid)
    {
		return new ResponseEntity<Student>(sservice.getStudentDetail(sid),HttpStatus.OK);
    	
    }
    
    
    //path in postman to Delete data ---> http://localhost:8080/Student/remove/1
    @DeleteMapping("/Student/remove/{sid}")

    public ResponseEntity<String>deleteStudentDetail(@PathVariable ("sid") int sid)
    {
    	sservice.deleteStudentDetail(sid);
    	return new ResponseEntity<String>("Deleted SuccessFully",HttpStatus.OK);
    }
    
    // Path in postman to update data ---> http://localhost:8080/Student/update/1
    @PutMapping("/Student/update/{sid}")
    public ResponseEntity<Student> updateStudentDetail(@PathVariable("sid") int sid, @Valid @RequestBody Student student) {
        Student updateStudentDetail = sservice.updateStudentDetail(student, sid);
        return new ResponseEntity<>(updateStudentDetail, HttpStatus.OK);
    }
    
}
