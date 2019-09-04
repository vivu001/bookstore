package com.example.bookstore.order;

import com.example.bookstore.user.User;
import com.example.bookstore.user.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;
    private UserRepo userRepo;

    public OrderService(OrderRepo orderRepo, UserRepo userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    public List<Order> getAllOrders() {
        return (List<Order>) this.orderRepo.findAll();
    }

    public List<Order> getOrdersOfUser(Long userId) {
        User user = this.userRepo.findById(userId).get();
        return this.orderRepo.findAllByUser(user);
    }

    public Order getOrderOfUser(int orderId) {
        return this.orderRepo.findById(orderId).get();
    }

    public Order createOrder(Long userId, Order order) {
        User user = this.userRepo.findById(userId).get();
        order.setUser(user);
        return this.orderRepo.save(order);
    }

    public Order updateOrder(int orderId, Order order) {
        Order oldOrder = this.orderRepo.findById(orderId).get();
        order.setId(oldOrder.getId());
        return this.orderRepo.save(oldOrder);
    }

    public List<Order> deleteOrdersOfUser(Long userId) {
        User user = this.userRepo.findById(userId).get();
        List<Order> orders = this.getOrdersOfUser(userId);
        this.orderRepo.deleteAllByUser(user);
        return orders;
    }

    public List<Order> deleteAllOrders() {
        List<Order> orders = (List<Order>) this.orderRepo.findAll();
        this.orderRepo.deleteAll();
        return orders;
    }
}
