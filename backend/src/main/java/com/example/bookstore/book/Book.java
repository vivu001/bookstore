package com.example.bookstore.book;

import com.example.bookstore.cart.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String publisher;
    private String author;
    private String year;
    private String isbn;
    private Double price;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Set<Cart> quantities;

    public Book() {
    }

    public Book(String title, String publisher, String author, String year, String isbn, Double price) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Cart> getQuantities() {
        return quantities;
    }

    public void setQuantities(Set<Cart> quantities) {
        this.quantities = quantities;
    }
}
