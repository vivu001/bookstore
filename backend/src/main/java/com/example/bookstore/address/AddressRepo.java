package com.example.bookstore.address;

import com.example.bookstore.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
    Address findByUser(User user);
}
