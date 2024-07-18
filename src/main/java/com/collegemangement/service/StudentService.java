package com.collegemangement.service;

import com.collegemangement.entity.Student;

public interface StudentService {

    Student addStudent (Student student);
	
	Student getStudentDetail(int sid);
	
	Student updateStudentDetail(Student  student, int sid);


	Student deleteStudentDetail(int tid);
	
	
}
