package com.example.bookstore.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) this.bookRepo.findAll();
    }

    public Book getBook(int bookId) {
        return this.bookRepo.findById(bookId).get();
    }

    public Book addBook(Book book) {
        return this.bookRepo.save(book);
    }

    public Book updateBook(Book book, int bookId) {
        book.setId(bookId);
        return this.bookRepo.save(book);
    }

    public Book deleteBook(int bookId) {
        Book book = this.getBook(bookId);
        this.bookRepo.deleteById(bookId);
        return book;
    }
}
