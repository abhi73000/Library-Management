package com.project;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.entity.Department;
import com.project.repository.DepartmentRepository;
import com.project.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    public DepartmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests adding a department using DepartmentService.
     * Verifies that the department is saved correctly.
     */
    @Test
    public void testAddDepartment() {
        // Setup
        Department department = new Department();
        department.setName("Computer Science");
        when(departmentRepository.save(department)).thenReturn(department);

        // Method call
        Department result = departmentService.addDepartment(department);

        // Assertion
        assertEquals("Computer Science", result.getName());
        verify(departmentRepository, times(1)).save(department);
    }

    /**
     * Tests listing all departments using DepartmentService.
     * Verifies that all departments are retrieved correctly.
     */
    @Test
    public void testListAllDepartments() {
        // Setup
        List<Department> departments = new ArrayList<>();
        departments.add(new Department());
        when(departmentRepository.findAll()).thenReturn(departments);

        // Method call
        List<Department> result = departmentService.listAllDepartments();

        // Assertion
        assertEquals(1, result.size());
        verify(departmentRepository, times(1)).findAll();
    }

    /**
     * Tests retrieving a department by its ID using DepartmentService.
     * Verifies that the correct department is retrieved.
     */
    @Test
    public void testGetDepartmentById() {
        // Setup
        Department department = new Department();
        department.setId(1L);
        department.setName("Computer Science");
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));

        // Method call
        Department result = departmentService.getDepartmentById(1L);

        // Assertion
        assertEquals("Computer Science", result.getName());
        verify(departmentRepository, times(1)).findById(1L);
    }
}
