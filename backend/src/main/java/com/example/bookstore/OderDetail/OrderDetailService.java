package com.example.bookstore.OderDetail;

import com.example.bookstore.Order.Order;
import com.example.bookstore.Order.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    private OrderDetailRepo orderDetailRepo;
    private OrderRepo orderRepo;

    public OrderDetailService(OrderDetailRepo orderDetailRepo, OrderRepo orderRepo) {
        this.orderDetailRepo = orderDetailRepo;
        this.orderRepo = orderRepo;
    }

    public List<OrderDetail> getAllOrderDetails() {
        return (List<OrderDetail>) this.orderDetailRepo.findAll();
    }

    public List<OrderDetail> getOrderDetailsByOrder(int orderId) {
        Order order = this.orderRepo.findById(orderId).get();
        return this.orderDetailRepo.findAllByOrder(order);
    }

    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return this.orderDetailRepo.save(orderDetail);
    }

    public OrderDetail updateOrderDetail(int orderDetailId, int quantity) {
        OrderDetail orderDetail = this.orderDetailRepo.findById(orderDetailId).get();
        orderDetail.setQuantity(quantity);
        return this.orderDetailRepo.save(orderDetail);
    }

    public OrderDetail deleteOrderDetail(int orderDetailId) {
        OrderDetail orderDetail = this.orderDetailRepo.findById(orderDetailId).get();
        this.orderDetailRepo.delete(orderDetail);
        return orderDetail;
    }
}
