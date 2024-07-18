package com.collegemangement.util;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import com.collegemangement.dto.TeacherDTO;
import com.collegemangement.entity.Teacher;
//this class responsible for convert from DTO to entity  and vice versa
//DTO is copy of entity
@Component
public class TeacherConverter {

	public Teacher ConvertTeacherDTOToTeacher(TeacherDTO tdto)
	{
		Teacher tc =new Teacher();
		if(tdto!=null)
		{
			BeanUtils.copyProperties(tdto, tc);
		}
		return tc;
	}
	
	public TeacherDTO ConvertTeacherToTeacherDTO(Teacher teacher)
	{
		TeacherDTO tdto =new TeacherDTO();
		if(teacher!=null)
		{
			BeanUtils.copyProperties(teacher, tdto);
		}
		return tdto;
	}
}
