package com.example.bookstore.Order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @GetMapping("/users/{userId}/orders")
    public List<Order> getOrdersOfUser(@PathVariable int userId) {
        return this.orderService.getOrdersOfUser(userId);
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrderOfUser(@PathVariable int orderId) {
        return this.orderService.getOrderOfUser(orderId);
    }

    @PostMapping("/users/{userId}/orders")
    public Order createOrder(@PathVariable int userId, @RequestBody Order order) {
        return this.orderService.createOrder(userId, order);
    }

    @PutMapping("/orders/{orderId}")
    public Order updateOrder(@PathVariable int orderId, @RequestBody Order order) {
        return this.orderService.updateOrder(orderId, order);
    }

    @DeleteMapping("/orders")
    public List<Order> deleteAllOrders() {
        return this.orderService.deleteAllOrders();
    }
}
