package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.entity.Department;
import com.project.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/library/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * Endpoint to add a new department.
     *
     * @param department The department to add.
     * @return The added department.
     */
    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    /**
     * Endpoint to retrieve all departments.
     *
     * @return A list of all departments.
     */
    @GetMapping
    public List<Department> listAllDepartments() {
        return departmentService.listAllDepartments();
    }

    /**
     * Endpoint to retrieve a department by its ID.
     *
     * @param id The ID of the department to retrieve.
     * @return The department with the specified ID, or null if not found.
     */
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }
}
