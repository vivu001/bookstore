package com.example.bookstore.store;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private StoreRepo storeRepo;

    public StoreService(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    public List<Store> getAllStores() {
        return (List<Store>) this.storeRepo.findAll();
    }

    public Store getStore(Long storeId) {
        return this.storeRepo.findById(storeId).get();
    }

    public Store createStore(Store store) {
        return this.storeRepo.save(store);
    }

    public Store updateStore(Long storeId, Store store) {
        store.setId(storeId);
        return this.storeRepo.save(store);
    }

    public Store deleteStore(Long storeId) {
        Store oldStore = this.storeRepo.findById(storeId).get();
        this.storeRepo.deleteById(storeId);
        return oldStore;
    }
}
