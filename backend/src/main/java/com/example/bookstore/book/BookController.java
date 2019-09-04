package com.example.bookstore.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return this.bookService.getBook(bookId);
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long bookId) {
        return this.bookService.updateBook(book, bookId);
    }

    @DeleteMapping("/{bookId")
    public Book deleteBook(@PathVariable Long bookId) {
        return this.bookService.deleteBook(bookId);
    }

}
