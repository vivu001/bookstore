package com.example.bookstore.OderDetail;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {
    private OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("")
    public List<OrderDetail> getAllOrderDetails() {
        return this.orderDetailService.getAllOrderDetails();
    }

    @GetMapping("/orders/{orderId}/orderDetails")
    public List<OrderDetail> getOrderDetailsByOrder(@PathVariable int orderId) {
        return this.orderDetailService.getOrderDetailsByOrder(orderId);
    }

    @PostMapping("/orderDetails")
    public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return this.orderDetailService.createOrderDetail(orderDetail);
    }

    @PutMapping("/orderDetails/{orderDetailId}/{quantity}")
    public OrderDetail updateOrderDetail(@PathVariable int orderDetailId, @PathVariable int quantity ) {
        return this.orderDetailService.updateOrderDetail(orderDetailId, quantity);
    }

    @DeleteMapping("/orderDetails/{orderDetailId}")
    public OrderDetail deleteOrderDetail(@PathVariable int orderDetailId) {
        return this.orderDetailService.deleteOrderDetail(orderDetailId);
    }

}
