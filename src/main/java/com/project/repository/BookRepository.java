package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    // Retrieves a list of books containing the specified title.
    List<Book> findByTitleContainingIgnoreCase(String title);
    
    // Retrieves a list of books by the specified author.
    List<Book> findByAuthorContainingIgnoreCase(String author);
    
    // Retrieves a list of books with the specified availability status.
    List<Book> findByAvailability(boolean availability);
    
    // Retrieves a book by its ISBN.
    Book findByISBN(String ISBN);
}
