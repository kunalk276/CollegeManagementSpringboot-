package com.collegemangement.service;

import com.collegemangement.entity.Department;
import java.util.List;

public interface DepartmentService {
	Department addDepartment(Department department);
    Department updateDepartment(Department department, int id);
    void deleteDepartment(int id);
    Department getDepartmentById(int id);
    List<Department> getAllDepartments();
}
