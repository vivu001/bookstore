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
    public List<Cart> getAllCartsOfUser(@PathVariable int userId) {
        return this.cartService.getAllCartsOfUser(userId);
    }

    @PostMapping("/users/{userId}/carts/books/{bookId}/{quantity}")
    public Cart addCard(@PathVariable int userId, @RequestBody Cart cart, @PathVariable int bookId, @PathVariable int quantity) {
        return this.cartService.addCard(userId, cart, bookId, quantity);
    }

    @PutMapping("/users/{userId}/carts/{cartId}/books/{bookId}/{quantity}")
    public Cart updateCart(@PathVariable int userId, @PathVariable int cartId, @RequestBody Cart cart, @PathVariable int bookId, @PathVariable int quantity) {
        return this.cartService.updateCart(userId, cartId, cart, bookId, quantity);
    }

    @DeleteMapping("/carts/{cartId}")
    public Cart deleteCart(@PathVariable int cartId) {
        return this.cartService.deleteCart(cartId);
    }

    @DeleteMapping("/users/{userId}/carts")
    public List<Cart> deleteAllCartsOfUser(@PathVariable int userId) {
        return this.cartService.deleteAllCartsOfUser(userId);
    }
}
