package com.example.bookstore.stock;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StockController {
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return this.stockService.getAllStocks();
    }

    @GetMapping("/{storeId}/stocks")
    public List<Stock> getStocksOfStore(@PathVariable Long storeId) {
        return this.stockService.getStocksOfStore(storeId);
    }

    @PostMapping("/{storeId}/stocks/books/{bookId}/{quantity}")
    public Stock createStock(@PathVariable Long storeId, @PathVariable Long bookId, @PathVariable int quantity) {
        return this.stockService.createStock(storeId, bookId, quantity);
    }

    @PutMapping("/{storeId}/stocks/books/{bookId}/{quantity}")
    public Stock updateStock(@PathVariable Long storeId, @PathVariable Long bookId, @PathVariable int quantity) {
        return this.stockService.updateStock(storeId, bookId, quantity);
    }

    @DeleteMapping("/{storeId}/stocks")
    public List<Stock> deleteAllStocksOfStore(@PathVariable Long storeId) {
        return this.stockService.deleteAllStocksOfStore(storeId);
    }

    @DeleteMapping("/{storeId}/stocks/books/{bookId}")
    public Stock deleteStockOfStore(@PathVariable Long storeId, @PathVariable Long bookId) {
        return this.stockService.deleteStockOfStore(storeId, bookId);
    }
}
