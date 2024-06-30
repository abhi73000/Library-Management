package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Department;
import com.project.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * Adds a new department to the database.
     *
     * @param department The department to add.
     * @return The added department.
     */
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /**
     * Retrieves all departments from the database.
     *
     * @return A list of all departments.
     */
    public List<Department> listAllDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * Retrieves a department by its ID.
     *
     * @param id The ID of the department to retrieve.
     * @return The department with the specified ID, or null if not found.
     */
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
