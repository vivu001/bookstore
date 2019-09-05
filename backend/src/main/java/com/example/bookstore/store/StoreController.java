package com.example.bookstore.store;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {
    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("")
    public List<Store> getAllStores() {
        return this.storeService.getAllStores();
    }

    @GetMapping("/{storeId}")
    public Store getStore(@PathVariable Long storeId) {
        return this.storeService.getStore(storeId);
    }

    @PostMapping("")
    public Store createStore(@RequestBody Store store) {
        return this.storeService.createStore(store);
    }

    @PutMapping("/{storeId}")
    public Store updateStore(@PathVariable Long storeId, @RequestBody Store store) {
        return this.storeService.updateStore(storeId, store);
    }

    @DeleteMapping("/{storeId}")
    public Store deleteStore(@PathVariable Long storeId) {
        return this.storeService.deleteStore(storeId);
    }
}
