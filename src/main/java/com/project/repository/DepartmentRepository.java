package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
