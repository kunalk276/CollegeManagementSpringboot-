package com.collegemangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.collegemangement.entity.Department;
import com.collegemangement.service.DepartmentService;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/Department/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.addDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable int id) {
        Department updatedDepartment = departmentService.updateDepartment(department, id);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}
