package com.collegemangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.collegemangement.dto.TeacherDTO;
import com.collegemangement.entity.Teacher;
import com.collegemangement.service.TeacherService;
import com.collegemangement.util.TeacherConverter;
import com.sun.net.httpserver.HttpServer;

import jakarta.validation.Valid;

@RestController
public class TeacherController {
    
    @Autowired
    private TeacherService tservice;
    
    @Autowired
    TeacherConverter tconvert;

     //path in postman to post data --->http://localhost:8080/Teacher/addTeacher
//    @PostMapping("/Teacher/addTeacher")
//    public ResponseEntity<Teacher> saveTeacher(@Valid @RequestBody Teacher teacher) {
//        Teacher savedTeacher = tservice.addTeacherDetail(teacher);
//        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
//        
//        
//    }
    
    //path in postman to get data --->  http://localhost:8080/Teacher/get/1
    @GetMapping("/Teacher/get/{tid}")
    public ResponseEntity<Teacher> getTeacherDeatil(@PathVariable ("tid") int tid)
    {
		return new ResponseEntity<Teacher>(tservice.getTeacherDeatil(tid),HttpStatus.OK);
    	
    }
    
    
    //path in postman to Delete data ---> http://localhost:8080/Teacher/remove/1
    @DeleteMapping("/Teacher/remove/{tid}")
    public ResponseEntity<String>deleteTeacher(@PathVariable ("tid") int tid)
    {
    	tservice.deleteTeacherDetail(tid);
    	return new ResponseEntity<String>("Deleted SuccessFully",HttpStatus.OK);
    }
    
     // Path in postman to update data ---> http://localhost:8080/Teacher/update/1
    @PutMapping("/Teacher/update/{tid}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("tid") int tid, @Valid @RequestBody Teacher teacher) {
        Teacher updatedTeacher = tservice.updateTeacherDetail(teacher, tid);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }
    
    @GetMapping("/Teacher/gettname/{tname}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable ("tname") String tname)
    {
    	return  (ResponseEntity<Teacher>) tservice.getTeacherByName(tname);
    	
    }
    
    @GetMapping("/Teacher/gettphone/{tphone}")
    public ResponseEntity<Teacher> getTeacherByPhone(@PathVariable ("tphone") int tphone)
    {
		return new ResponseEntity<Teacher>(tservice.getTeacherByPhone(tphone),HttpStatus.OK);
    	
    }
    
    @GetMapping("/Teacher/getdesig/{designation}")
    public List<Teacher> getTeacherdesignation(@PathVariable ("designation") String designation)
    {
		return  tservice.getTeacherdesignation(designation);
    	
    }
    
    @PostMapping("/Teacher/addTeacher")
	public ResponseEntity<TeacherDTO> saveTeacher(@Valid @RequestBody TeacherDTO tdto)
	{
		Teacher teacher=tconvert.ConvertTeacherDTOToTeacher(tdto);
		return new ResponseEntity<TeacherDTO>(tservice.addTeacher(teacher),HttpStatus.CREATED);
	}
    
}

