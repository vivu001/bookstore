package com.example.bookstore.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends CrudRepository<Store, Long> {
}
