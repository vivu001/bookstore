package com.example.bookstore.order;

import com.example.bookstore.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
    List<Order> findAllByUser(User user);

    @Transactional
    List<Order> deleteAllByUser(User user);
}
