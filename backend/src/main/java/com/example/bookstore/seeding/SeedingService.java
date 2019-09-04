package com.example.bookstore.seeding;

import com.example.bookstore.address.AddressRepo;
import com.example.bookstore.book.BookRepo;
import com.example.bookstore.order.OrderRepo;
import com.example.bookstore.user.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class SeedingService {
    private AddressRepo addressRepo;
    private UserRepo userRepo;
    private BookRepo bookRepo;
    private OrderRepo orderRepo;
    private Seeding seeding = new Seeding();

    public SeedingService(AddressRepo addressRepo, UserRepo userRepo, BookRepo bookRepo, OrderRepo orderRepo) {
        this.addressRepo = addressRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
        this.orderRepo = orderRepo;
    }

    public String seeding() {
        this.addressRepo.saveAll(seeding.createAddress());
        this.userRepo.saveAll(seeding.createUser());
        this.bookRepo.saveAll(seeding.createBook());
        this.orderRepo.saveAll(seeding.createOrder());
        return "Seeding was successfully !!! ";
    }
}
