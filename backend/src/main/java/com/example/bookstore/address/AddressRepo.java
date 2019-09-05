package com.example.bookstore.address;

import com.example.bookstore.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {
    Address findByUser(User user);
}
