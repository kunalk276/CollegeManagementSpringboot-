package com.collegemangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.collegemangement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
