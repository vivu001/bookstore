package com.example.bookstore.cart;

import com.example.bookstore.book.Book;
import com.example.bookstore.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Cart {

    @EmbeddedId
    private CartKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    public CartKey getId() {
        return id;
    }

    public void setId(CartKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
