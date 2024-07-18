package com.collegemangement.serviceimplement;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemangement.dto.TeacherDTO;
import com.collegemangement.entity.Teacher;
import com.collegemangement.exception.TeacherIdNotFoundException;
import com.collegemangement.repository.TeacherRepository;
import com.collegemangement.service.TeacherService;
import com.collegemangement.util.TeacherConverter;

import jakarta.validation.constraints.AssertFalse.List;


@Service
public class TeacherServiceImple implements TeacherService {
	
	@Autowired
	TeacherRepository techerRepo;
	
	@Override
	public Teacher addTeacherDetail(Teacher teacher) {
		// TODO Auto-generated method stub
		return techerRepo.save(teacher);
	}
	
    @Override
	public Teacher getTeacherDeatil(int tid) {
		// TODO Auto-generated method stub
		return techerRepo.findById(tid).
				orElseThrow(()-> new TeacherIdNotFoundException("Teacher Id not correct"));   
	}

    @Override
    public Teacher updateTeacherDetail(Teacher updatedTeacher, int tid) {
       
        Teacher existingTeacher = techerRepo.findById(tid)
                .orElseThrow(() -> new TeacherIdNotFoundException("Teacher with ID " + tid + " not found"));

       
        existingTeacher.setTname(updatedTeacher.getTname());
        existingTeacher.setTsurname(updatedTeacher.getTsurname());
        existingTeacher.setTphone(updatedTeacher.getTphone());
        existingTeacher.setDesignation(updatedTeacher.getDesignation());
        existingTeacher.setTemail(updatedTeacher.getTemail());

        
        return techerRepo.save(existingTeacher);
    }

	 @Override
	    public Teacher deleteTeacherDetail(int tid) {
	        Teacher teacher = techerRepo.findById(tid)
	                .orElseThrow(() -> new TeacherIdNotFoundException("Teacher Id not found"));
	        techerRepo.delete(teacher);
			return teacher;
	    }

	@Override
	public Teacher getTeacherByPhone(long tphone) {
		// TODO Auto-generated method stub
		return techerRepo.findTeacherByPhone(tphone);
	}

	@Override
	public java.util.List<Teacher> getTeacherdesignation(String designation) {
		// TODO Auto-generated method stub
		return techerRepo.findTeacherdesignation(designation);
	}

	@Override
	public java.util.List<Teacher> getTeacherByName(String tname) {
		// TODO Auto-generated method stub
		return techerRepo.findTeachername(tname);
	}

	@Autowired
	TeacherConverter tcover;
	@Override
	public TeacherDTO addTeacher(Teacher teacher) {
		return tcover.ConvertTeacherToTeacherDTO(teacher);
	}
	
	
	


	
	
}