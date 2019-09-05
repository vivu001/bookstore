package com.example.bookstore.seeding;

import com.example.bookstore.address.AddressRepo;
import com.example.bookstore.book.BookRepo;
import com.example.bookstore.cart.CartRepo;
import com.example.bookstore.oderDetail.OrderDetailRepo;
import com.example.bookstore.order.OrderRepo;
import com.example.bookstore.stock.StockRepo;
import com.example.bookstore.store.StoreRepo;
import com.example.bookstore.user.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class SeedingService {
    private AddressRepo addressRepo;
    private UserRepo userRepo;
    private BookRepo bookRepo;
    private CartRepo cartRepo;
    private OrderRepo orderRepo;
    private OrderDetailRepo orderDetailRepo;
    private StoreRepo storeRepo;
    private StockRepo stockRepo;

    private Seeding seeding;

    public SeedingService(AddressRepo addressRepo, UserRepo userRepo, BookRepo bookRepo, CartRepo cartRepo, OrderRepo orderRepo, OrderDetailRepo orderDetailRepo, StoreRepo storeRepo, StockRepo stockRepo) {
        this.addressRepo = addressRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
        this.cartRepo = cartRepo;
        this.orderRepo = orderRepo;
        this.orderDetailRepo = orderDetailRepo;
        this.storeRepo = storeRepo;
        this.stockRepo = stockRepo;
        this.seeding = new Seeding();
    }

    public String seeding() {
        this.userRepo.saveAll(seeding.createUser());
        this.addressRepo.saveAll(seeding.createAddress());
        this.bookRepo.saveAll(seeding.createBook());
        this.cartRepo.saveAll(seeding.createCart());
        this.orderRepo.saveAll(seeding.createOrder());
        this.orderDetailRepo.saveAll(seeding.createOrderDetail());
        this.storeRepo.saveAll(seeding.createStore());
        this.stockRepo.saveAll(seeding.createStock());
        return "Seeding was successfully !!! ";
    }
}
