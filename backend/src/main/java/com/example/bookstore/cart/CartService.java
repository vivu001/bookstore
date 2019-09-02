package com.example.bookstore.cart;

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

    public List<Cart> getAllCartsOfUser(int userId) {
        User user = this.userRepo.findById(userId).get();
        return (List<Cart>) this.cartRepo.findCartsByUser(user);
    }

    public Cart addCard(int userId, Cart cart, int bookId, int quantity) {
        cart.setUser(userRepo.findById(userId).get());
        cart.setBook(bookRepo.findById(bookId).get());
        cart.setQuantity(quantity);
        return this.cartRepo.save(cart);
    }

    public Cart updateCart(int userId, int cartId, Cart cart, int bookId, int quantity) {
        cart.setId(cartId);
        cart.setUser(userRepo.findById(userId).get());
        cart.setBook(bookRepo.findById(bookId).get());
        cart.setQuantity(quantity);
        return this.cartRepo.save(cart);
    }

    public Cart deleteCart(int cartId) {
        Cart cart = this.cartRepo.findById(cartId).get();
        this.cartRepo.delete(cart);
        return cart;
    }

    public List<Cart> deleteAllCartsOfUser(int userId) {
        User user = this.userRepo.findById(userId).get();
        List<Cart> carts = this.cartRepo.findCartsByUser(user);
        for (Cart cart : carts) {
            this.cartRepo.delete(cart);
        }
        return carts;
    }
}
