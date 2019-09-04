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

    public List<Cart> getAllCartsOfUser(Long userId) {
        User user = this.userRepo.findById(userId).get();
        return (List<Cart>) this.cartRepo.findCartsByUser(user);
    }

    public Cart addCard(Long userId, Cart cart, Long bookId, int quantity) {
        CartKey cartId = new CartKey(userId, bookId);
        cart.setId(cartId);
        cart.setQuantity(quantity);
        return this.cartRepo.save(cart);
    }

    public Cart updateCart(Long userId, Cart cart, Long bookId, int quantity) {
        CartKey cartId = new CartKey(userId, bookId);
        cart.setId(cartId);
        cart.setQuantity(quantity);
        return this.cartRepo.save(cart);
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
        this.cartRepo.deleteAllByUser(user);
        return carts;
    }
}

