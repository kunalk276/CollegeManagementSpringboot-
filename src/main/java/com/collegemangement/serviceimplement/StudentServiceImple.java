package com.collegemangement.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemangement.entity.Student;
import com.collegemangement.exception.StudentNotFoundException;
import com.collegemangement.repository.StudentRepository;
import com.collegemangement.service.StudentService;

@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	StudentRepository srepo;
	
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return srepo.save(student);
	}

	@Override
	public Student getStudentDetail(int sid) {
		return srepo.findById(sid).
				orElseThrow(()-> new StudentNotFoundException("Teacher Id not correct"));   
	}

	@Override
	public Student updateStudentDetail(Student updatedStudent, int sid) {

		Student existingStudent = srepo.findById(sid)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + sid + " not found"));
		
		existingStudent.setSfname(updatedStudent.getSfname());
        existingStudent.setSlname(updatedStudent.getSlname());
        existingStudent.setSphone(updatedStudent.getSphone());
        existingStudent.setSemail(updatedStudent.getSemail());
        existingStudent.setSeduc(updatedStudent.getSeduc());
        existingStudent.setSaddr(updatedStudent.getSaddr());

        return srepo.save(existingStudent);


	}

	@Override
	public Student deleteStudentDetail(int sid) {
		Student student = srepo.findById(sid)
                .orElseThrow(() -> new StudentNotFoundException("Teacher Id not found"));
        srepo.delete(student);
		return student;
	}

}
