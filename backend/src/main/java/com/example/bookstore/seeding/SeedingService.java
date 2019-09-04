package com.example.bookstore.seeding;

import com.example.bookstore.address.AddressRepo;
import com.example.bookstore.book.BookRepo;
import com.example.bookstore.cart.CartRepo;
import com.example.bookstore.oderDetail.OrderDetail;
import com.example.bookstore.oderDetail.OrderDetailRepo;
import com.example.bookstore.order.OrderRepo;
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
    private Seeding seeding;

    public SeedingService(AddressRepo addressRepo, UserRepo userRepo, BookRepo bookRepo, CartRepo cartRepo, OrderRepo orderRepo, OrderDetailRepo orderDetailRepo) {
        this.addressRepo = addressRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
        this.cartRepo = cartRepo;
        this.orderRepo = orderRepo;
        this.orderDetailRepo = orderDetailRepo;
        this.seeding = new Seeding();
    }

    public String seeding() {
        this.addressRepo.saveAll(seeding.createAddress());
        this.userRepo.saveAll(seeding.createUser());
        this.bookRepo.saveAll(seeding.createBook());
        this.cartRepo.saveAll(seeding.createCart());
        this.orderRepo.saveAll(seeding.createOrder());
        this.orderDetailRepo.saveAll(seeding.createOrderDetail());
        return "Seeding was successfully !!! ";
    }
}
