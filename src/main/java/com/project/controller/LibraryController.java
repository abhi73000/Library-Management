package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.entity.Book;
import com.project.service.LibraryService;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    /**
     * Endpoint to add a new book to the library.
     *
     * @param book The book to add.
     */
    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        libraryService.addBook(book);
    }

    /**
     * Endpoint to remove a book from the library by ISBN.
     *
     * @param isbn The ISBN of the book to remove.
     */
    @DeleteMapping("/books/{isbn}")
    public void removeBook(@PathVariable String isbn) {
        libraryService.removeBook(isbn);
    }

    /**
     * Endpoint to find books in the library by title (case-insensitive search).
     *
     * @param title The title to search for.
     * @return A list of books matching the title.
     */
    @GetMapping("/books/title/{title}")
    public List<Book> findBookByTitle(@PathVariable String title) {
        return libraryService.findBookByTitle(title);
    }

    /**
     * Endpoint to find books in the library by author (case-insensitive search).
     *
     * @param author The author to search for.
     * @return A list of books by the specified author.
     */
    @GetMapping("/books/author/{author}")
    public List<Book> findBookByAuthor(@PathVariable String author) {
        return libraryService.findBookByAuthor(author);
    }

    /**
     * Endpoint to retrieve all books in the library.
     *
     * @return A list of all books in the library.
     */
    @GetMapping("/books")
    public List<Book> listAllBooks() {
        return libraryService.listAllBooks();
    }

    /**
     * Endpoint to retrieve all available books in the library.
     *
     * @return A list of available books.
     */
    @GetMapping("/books/available")
    public List<Book> listAvailableBooks() {
        return libraryService.listAvailableBooks();
    }
}
