package com.example.bookstore.oderDetail;

import com.example.bookstore.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends CrudRepository<OrderDetail, Integer> {
    List<OrderDetail> findAllByOrder(Order order);
}
