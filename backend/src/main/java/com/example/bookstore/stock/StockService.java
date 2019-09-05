package com.example.bookstore.stock;

import com.example.bookstore.book.Book;
import com.example.bookstore.book.BookRepo;
import com.example.bookstore.store.Store;
import com.example.bookstore.store.StoreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private StockRepo stockRepo;
    private StoreRepo storeRepo;
    private BookRepo bookRepo;

    public StockService(StockRepo stockRepo, StoreRepo storeRepo, BookRepo bookRepo) {
        this.stockRepo = stockRepo;
        this.storeRepo = storeRepo;
        this.bookRepo = bookRepo;
    }

    public List<Stock> getAllStocks() {
        return (List<Stock>) this.stockRepo.findAll();
    }

    public List<Stock> getStocksOfStore(Long storeId) {
        Store store = this.storeRepo.findById(storeId).get();
        return this.stockRepo.findAllByStore(store);
    }

    public Stock createStock(Long storeId, Long bookId, int quantity) {
        Store store = this.storeRepo.findById(storeId).get();
        Book book = this.bookRepo.findById(bookId).get();
        return this.stockRepo.save(new Stock(store, book, quantity));
    }

    public Stock updateStock(Long storeId, Long bookId, int quantity) {
        Store store = this.storeRepo.findById(storeId).get();
        Book book = this.bookRepo.findById(bookId).get();
        return this.stockRepo.save(new Stock(store, book, quantity));
    }

    public List<Stock> deleteAllStocksOfStore(Long storeId) {
        Store store = this.storeRepo.findById(storeId).get();
        List<Stock> stocks = this.stockRepo.findAllByStore(store);
        return this.stockRepo.deleteAllByStore(store);
    }

    public Stock deleteStockOfStore(Long storeId, Long bookId) {
        StockKey stockKey = new StockKey(storeId, bookId);
        Stock stock = this.stockRepo.findById(stockKey).get();
        this.stockRepo.deleteById(stockKey);
        return stock;
    }
}

























