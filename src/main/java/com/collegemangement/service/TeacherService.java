package com.collegemangement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.collegemangement.dto.TeacherDTO;
import com.collegemangement.entity.Teacher;


@Service
public interface TeacherService {

	Teacher addTeacherDetail (Teacher teacher);
	TeacherDTO addTeacher(Teacher teacher);
	
	Teacher getTeacherDeatil(int tid);
	
	Teacher updateTeacherDetail(Teacher teacher, int tid);


	Teacher deleteTeacherDetail(int tid);

	Teacher getTeacherByPhone(long tphone);
	
	List<Teacher> getTeacherdesignation(String designation);
	
	List<Teacher> getTeacherByName(String tname);
}
