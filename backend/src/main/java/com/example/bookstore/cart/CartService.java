package com.example.bookstore.cart;

import com.example.bookstore.book.Book;
import com.example.bookstore.book.BookRepo;
import com.example.bookstore.user.User;
import com.example.bookstore.user.UserRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    private CartRepo cartRepo;
    private UserRepo userRepo;
    private BookRepo bookRepo;

    public CartService(CartRepo cartRepo, UserRepo userRepo, BookRepo bookRepo) {
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    public List<Cart> getAllCarts() {
        return (List<Cart>) this.cartRepo.findAll();
    }

    public List<Cart> getAllCartsOfUser(Long userId) {
        User user = this.userRepo.findById(userId).get();
        return (List<Cart>) this.cartRepo.findCartsByUser(user);
    }

    public Cart addCart(Long userId, Long bookId, int quantity) {
        User user = this.userRepo.findById(userId).get();
        Book book = this.bookRepo.findById(bookId).get();
        return this.cartRepo.save(new Cart(user, book, quantity));
    }

    public Cart updateCart(Long userId, Long bookId, int quantity) {
        User user = this.userRepo.findById(userId).get();
        Book book = this.bookRepo.findById(bookId).get();
        return this.cartRepo.save(new Cart(user, book, quantity));
    }

    public Cart deleteCart(Long userId, Long bookId) {
        CartKey cartId = new CartKey(userId, bookId);
        Cart cart = this.cartRepo.findById(cartId).get();
        this.cartRepo.deleteById(cartId);
        return cart;
    }

    public List<Cart> deleteAllCartsOfUser(Long userId) {
        User user = this.userRepo.findById(userId).get();
        List<Cart> carts = this.cartRepo.findCartsByUser(user);
        return this.cartRepo.deleteAllByUser(user);
    }
}

