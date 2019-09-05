package com.example.bookstore.stock;

import com.example.bookstore.book.Book;
import com.example.bookstore.store.Store;

import javax.persistence.*;

@Entity
public class Stock {

    @EmbeddedId
    private StockKey id;

    @ManyToOne
    @MapsId("store_id")
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    public Stock() {
    }

    public Stock(Store store, Book book, int quantity) {
        id = new StockKey(store.getId(), book.getId());
        this.store = store;
        this.book = book;
        this.quantity = quantity;
    }

    public StockKey getId() {
        return id;
    }

    public void setId(StockKey id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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
