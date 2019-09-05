package com.example.bookstore.seeding;

import com.example.bookstore.address.Address;
import com.example.bookstore.book.Book;
import com.example.bookstore.cart.Cart;
import com.example.bookstore.oderDetail.OrderDetail;
import com.example.bookstore.order.Order;
import com.example.bookstore.order.OrderStatus;
import com.example.bookstore.order.PaymentMethod;
import com.example.bookstore.stock.Stock;
import com.example.bookstore.store.Store;
import com.example.bookstore.user.Gender;
import com.example.bookstore.user.User;
import java.util.ArrayList;
import java.util.List;

public class Seeding {
    private List<Address> addresses = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Cart> carts = new ArrayList<>();
    private List<OrderDetail> orderDetails = new ArrayList<>();
    private List<Store> stores = new ArrayList<>();
    private List<Stock> stocks = new ArrayList<>();

    public List<User> createUser() {
        users.add(new User("Thomas", "Mueller", Gender.MALE, "20.01.2000", "thomas1234@aol.de"));
        users.add(new User("Rebekah", "Alfonso", Gender.FEMALE, "15.4.1986", "evra.pat@yahoo.com"));
        users.add(new User("Emma", "Stone", Gender.FEMALE, "08.11.1993", "stone.emma93@gmx.com"));
        return users;
    }

    public List<Address> createAddress() {
        addresses.add(new Address("Emil Figge", "45", "44227", "Dortmund", "Germany", users.get(0)));
        addresses.add(new Address("Walnut Drive", "1859", "58078", "West Fango", "Canada", users.get(1)));
        addresses.add(new Address("Mahlon Street", "433", "08527", "New Jersey", "USA", users.get(2)));
        return addresses;
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

    public List<Cart> createCart() {
        carts.add(new Cart(users.get(0), books.get(2), 5));
        carts.add(new Cart(users.get(0), books.get(0), 1));
        carts.add(new Cart(users.get(2), books.get(1), 8));
        carts.add(new Cart(users.get(2), books.get(2), 25));
        carts.add(new Cart(users.get(1), books.get(1), 10));
        carts.add(new Cart(users.get(1), books.get(0), 4));
        return carts;
    }

    public List<OrderDetail> createOrderDetail() {
        orderDetails.add(new OrderDetail(5, books.get(2), orders.get(0)));
        orderDetails.add(new OrderDetail(1, books.get(0), orders.get(0)));
        orderDetails.add(new OrderDetail(8, books.get(1), orders.get(2)));
        orderDetails.add(new OrderDetail(25, books.get(2), orders.get(2)));
        orderDetails.add(new OrderDetail(10, books.get(1), orders.get(1)));
        orderDetails.add(new OrderDetail(4, books.get(0), orders.get(1)));
        return orderDetails;
    }

    public List<Store> createStore() {
        stores.add(new Store("Mayersche Buchhandlung", "Westenhellweg", "37-41", "Dortmund", "44137", "+49 231 7766 6630", 45000));
        stores.add(new Store("Dussmann the Museum Shop", "Potsdamer", "2", "Berlin", "10785 ", "+49 1678 267 198", 100000));
        stores.add(new Store("Lehmanns Media GmbH", "Kurze Muehren", "6", "Hamburg", "20095", "+49 1725 029 975", 67000));
        stores.add(new Store("Hugendubel", "Steinweg", "12", "Frankfurt", "60313", "+49 1520 144 611", 22000));
        stores.add(new Store("Bookstore Georg Blendl", "Pacellistraße", "5", "Muenchen", "80333", "+49 1763 999 206", 35000));
        return stores;
    }

    public List<Stock> createStock() {
        stocks.add(new Stock(stores.get(0), books.get(0), 120));
        stocks.add(new Stock(stores.get(0), books.get(1), 250));
        stocks.add(new Stock(stores.get(0), books.get(2), 80));
        stocks.add(new Stock(stores.get(1), books.get(0), 20));
        stocks.add(new Stock(stores.get(1), books.get(1), 50));
        stocks.add(new Stock(stores.get(1), books.get(2), 35));
        stocks.add(new Stock(stores.get(2), books.get(0), 10));
        stocks.add(new Stock(stores.get(2), books.get(1), 25));
        stocks.add(new Stock(stores.get(2), books.get(2), 100));
        return stocks;
    }

}
