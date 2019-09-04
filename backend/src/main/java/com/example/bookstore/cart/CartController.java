package com.example.bookstore.cart;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/users/carts")
    public List<Cart> getAllCarts() {
        return this.cartService.getAllCarts();
    }

    @GetMapping("/users/{userId}/carts")
    public List<Cart> getAllCartsOfUser(@PathVariable Long userId) {
        return this.cartService.getAllCartsOfUser(userId);
    }

    @PostMapping("/users/{userId}/carts/books/{bookId}/{quantity}")
    public Cart addCard(@PathVariable Long userId, @RequestBody Cart cart, @PathVariable Long bookId, @PathVariable int quantity) {
        return this.cartService.addCard(userId, cart, bookId, quantity);
    }

    @PutMapping("/users/{userId}/carts/books/{bookId}/{quantity}")
    public Cart updateCart(@PathVariable Long userId, @RequestBody Cart cart, @PathVariable Long bookId, @PathVariable int quantity) {
        return this.cartService.updateCart(userId, cart, bookId, quantity);
    }

    @DeleteMapping("/users/{userId}/carts/books/{bookId}")
    public Cart deleteCart(@PathVariable Long userId, @PathVariable Long bookId) {
        return this.cartService.deleteCart(userId, bookId);
    }

    @DeleteMapping("/users/{userId}/carts")
    public List<Cart> deleteAllCartsOfUser(@PathVariable Long userId) {
        return this.cartService.deleteAllCartsOfUser(userId);
    }
}
