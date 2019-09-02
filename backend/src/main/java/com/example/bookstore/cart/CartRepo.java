package com.example.bookstore.cart;

import com.example.bookstore.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends CrudRepository<Cart, Integer> {
    List<Cart> findCartsByUser(User user);
}
