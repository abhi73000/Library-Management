package com.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Book;
import com.project.entity.Department;
import com.project.repository.BookRepository;
import com.project.repository.DepartmentRepository;

@Component
public class DataInitializationService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void initializeData() {
        // Add initial departments
        Department department1 = new Department();
        department1.setName("Computer Science");
        departmentRepository.save(department1);

        Department department2 = new Department();
        department2.setName("Literature");
        departmentRepository.save(department2);

        // Add initial books
        Book book1 = new Book();
        book1.setTitle("Effective Java");
        book1.setAuthor("Joshua Bloch");
        book1.setISBN("978-0134685991");
        book1.setGenre("Programming");
        book1.setPublicationYear(2018);
        book1.setAvailability(true);
        book1.setDepartment(department1);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("Pride and Prejudice");
        book2.setAuthor("Jane Austen");
        book2.setISBN("978-0486295558");
        book2.setGenre("Classic Literature");
        book2.setPublicationYear(1813);
        book2.setAvailability(true);
        book2.setDepartment(department2);
        bookRepository.save(book2);
    }
}

