package com.collegemangement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.collegemangement.entity.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

	@Query("select t from Teacher t where t.tphone=?1")
	Teacher findTeacherByPhone(long tphone);
	
	@Query("select t from Teacher t where t.designation like ?1% order by tname")
	List<Teacher> findTeacherdesignation(String designation);
	
	@Query("select t from Teacher t where t.tname like ?1% order by tname")
	List<Teacher> findTeachername(String tname);
}
