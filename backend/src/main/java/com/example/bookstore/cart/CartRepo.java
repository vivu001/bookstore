package com.example.bookstore.cart;

import com.example.bookstore.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartRepo extends CrudRepository<Cart, CartKey> {
    List<Cart> findCartsByUser(User user);

    @Transactional
    List<Cart> deleteAllByUser(User user);
}
