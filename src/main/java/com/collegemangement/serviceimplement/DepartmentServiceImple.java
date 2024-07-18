package com.collegemangement.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collegemangement.entity.Department;
import com.collegemangement.repository.DepartmentRepository;
import com.collegemangement.service.DepartmentService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class DepartmentServiceImple implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department, int id) {
        
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));

        
        existingDepartment.setDeptName(department.getDeptName());
        existingDepartment.setDeptHOD(department.getDeptHOD());
        existingDepartment.setNoOfEmpl(department.getNoOfEmpl());

        
        return departmentRepository.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

	
}