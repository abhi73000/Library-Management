package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Book;
import com.project.entity.Department;
import com.project.repository.BookRepository;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DepartmentService departmentService;

    /**
     * Adds a book to the library.
     *
     * @param book The book to add.
     */
    public void addBook(Book book) {

        // Retrieve the department for the book
        Department department = departmentService.getDepartmentById(book.getDepartment().getId());
        if (department == null) {
            throw new IllegalArgumentException("Department does not exist.");
        }

        // Check if a book with the same ISBN already exists in any department
        Book existingBook = bookRepository.findByISBN(book.getISBN());
        if (existingBook != null && !existingBook.getDepartment().getId().equals(department.getId())) {
            throw new IllegalArgumentException("Book with this ISBN already exists in another department.");
        }

        // Assign the department to the book and save it
        book.setDepartment(department);
        bookRepository.save(book);
    }

    /**
     * Removes a book from the library by ISBN.
     *
     * @param ISBN The ISBN of the book to remove.
     */
    public void removeBook(String ISBN) {
        // Find the book by ISBN and delete it if found
        Book book = bookRepository.findByISBN(ISBN);
        if (book != null) {
            bookRepository.delete(book);
        }
    }

    /**
     * Finds books in the library by title.
     *
     * @param title The title to search for.
     * @return A list of books matching the title.
     */
    public List<Book> findBookByTitle(String title) {
        // Search books by title
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    /**
     * Finds books in the library by author.
     *
     * @param author The author to search for.
     * @return A list of books by the author.
     */
    public List<Book> findBookByAuthor(String author) {
        // Search books by author
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    /**
     * Retrieves all books in the library.
     *
     * @return A list of all books.
     */
    public List<Book> listAllBooks() {
        // Retrieve all books from the repository
        return bookRepository.findAll();
    }

    /**
     * Retrieves all available books in the library.
     *
     * @return A list of available books.
     */
    public List<Book> listAvailableBooks() {
        // Retrieve books with availability set to true
        return bookRepository.findByAvailability(true);
    }
}
