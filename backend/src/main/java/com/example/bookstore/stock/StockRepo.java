package com.example.bookstore.stock;

import com.example.bookstore.store.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StockRepo extends CrudRepository<Stock, StockKey> {
    List<Stock> findAllByStore(Store store);

    @Transactional
    List<Stock> deleteAllByStore(Store store);
}
