package com.example.bookstore.seeding;

import com.example.bookstore.address.Address;
import com.example.bookstore.book.Book;
import com.example.bookstore.order.Order;
import com.example.bookstore.order.OrderStatus;
import com.example.bookstore.order.PaymentMethod;
import com.example.bookstore.user.Gender;
import com.example.bookstore.user.User;

import java.util.ArrayList;
import java.util.List;

public class Seeding {
    private List<Address> addresses = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public List<Address> createAddress() {
        addresses.add(new Address("Emil Figge", "45", "44227", "Dortmund", "Germany"));
        addresses.add(new Address("Walnut Drive", "1859", "58078", "West Fango", "Canada"));
        addresses.add(new Address("Mahlon Street", "433", "08527", "New Jersey", "USA"));
        return addresses;
    }

    public List<User> createUser() {
        users.add(new User("Thomas", "Mueller", Gender.MALE, "20.01.2000", addresses.get(0), "thomas1234@aol.de"));
        users.add(new User("Rebekah", "Alfonso", Gender.FEMALE, "15.4.1986", addresses.get(1), "evra.pat@yahoo.com"));
        users.add(new User("Emma", "Stone", Gender.FEMALE, "08.11.1993", addresses.get(2), "stone.emma93@gmx.com"));
        return users;
    }

    public List<Book> createBook() {
        books.add(new Book("Kaffee und Zigaretten", "Luchterhand Literaturverlag", "Ferdinand von Schirach", "2019", "978-3-630-87610-8", 20.00));
        books.add(new Book("Goldschatz", "Diogenes Verlag AG", "Ingrid Noll", "2019", "978-3-257-07054-5", 24.00));
        books.add(new Book("Veggies", "Dorling Kindersley", "Jamie Oliver", "2019", "978-3-8310-3828-2", 26.95));
        return books;
    }

    public List<Order> createOrder() {
        orders.add(new Order("03.09.2019", OrderStatus.PROCESSING, PaymentMethod.CREDIT, users.get(0)));
        orders.add(new Order("31.08.2019", OrderStatus.PAID, PaymentMethod.TRANSFER, users.get(1)));
        orders.add(new Order("17.08.2019", OrderStatus.RETURNED, PaymentMethod.PAYPAL, users.get(2)));
        return orders;
    }
}
