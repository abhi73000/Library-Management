package com.project;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.entity.Book;
import com.project.entity.Department;
import com.project.repository.BookRepository;
import com.project.repository.DepartmentRepository;
import com.project.service.DepartmentService;
import com.project.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LibraryServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private DepartmentService departmentService;

    @InjectMocks
    private LibraryService libraryService;

    public LibraryServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the addition of a book to the library.
     */
    @Test
    public void testAddBook() {
        // Setup
        Department department = new Department();
        department.setId(1L);
        department.setName("Computer Science");

        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setISBN("978-0134685991");
        book.setGenre("Programming");
        book.setPublicationYear(2018);
        book.setAvailability(true);
        book.setDepartment(department);

        // Mock behavior
        when(departmentService.getDepartmentById(1L)).thenReturn(department);
        when(bookRepository.save(book)).thenReturn(book);

        // Method call
        libraryService.addBook(book);

        // Verification
        verify(departmentService, times(1)).getDepartmentById(1L);
        verify(bookRepository, times(1)).save(book);
    }

    /**
     * Tests the removal of a book from the library.
     */
    @Test
    public void testRemoveBook() {
        // Setup
        Book book = new Book();
        book.setISBN("978-0134685991");

        // Mock behavior
        when(bookRepository.findByISBN("978-0134685991")).thenReturn(book);

        // Method call
        libraryService.removeBook("978-0134685991");

        // Verification
        verify(bookRepository, times(1)).findByISBN("978-0134685991");
        verify(bookRepository, times(1)).delete(book);
    }

    /**
     * Tests searching for books by title.
     */
    @Test
    public void testFindBookByTitle() {
        // Setup
        List<Book> books = new ArrayList<>();
        books.add(new Book());

        // Mock behavior
        when(bookRepository.findByTitleContainingIgnoreCase("Effective Java")).thenReturn(books);

        // Method call
        List<Book> result = libraryService.findBookByTitle("Effective Java");

        // Verification
        assertEquals(1, result.size());
        verify(bookRepository, times(1)).findByTitleContainingIgnoreCase("Effective Java");
    }

    /**
     * Tests searching for books by author.
     */
    @Test
    public void testFindBookByAuthor() {
        // Setup
        List<Book> books = new ArrayList<>();
        books.add(new Book());

        // Mock behavior
        when(bookRepository.findByAuthorContainingIgnoreCase("Joshua Bloch")).thenReturn(books);

        // Method call
        List<Book> result = libraryService.findBookByAuthor("Joshua Bloch");

        // Verification
        assertEquals(1, result.size());
        verify(bookRepository, times(1)).findByAuthorContainingIgnoreCase("Joshua Bloch");
    }

    /**
     * Tests listing all books in the library.
     */
    @Test
    public void testListAllBooks() {
        // Setup
        List<Book> books = new ArrayList<>();
        books.add(new Book());

        // Mock behavior
        when(bookRepository.findAll()).thenReturn(books);

        // Method call
        List<Book> result = libraryService.listAllBooks();

        // Verification
        assertEquals(1, result.size());
        verify(bookRepository, times(1)).findAll();
    }

    /**
     * Tests listing available books in the library.
     */
    @Test
    public void testListAvailableBooks() {
        // Setup
        List<Book> books = new ArrayList<>();
        books.add(new Book());

        // Mock behavior
        when(bookRepository.findByAvailability(true)).thenReturn(books);

        // Method call
        List<Book> result = libraryService.listAvailableBooks();

        // Verification
        assertEquals(1, result.size());
        verify(bookRepository, times(1)).findByAvailability(true);
    }
}
