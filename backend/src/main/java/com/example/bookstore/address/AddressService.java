package com.example.bookstore.address;

import com.example.bookstore.user.User;
import com.example.bookstore.user.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepo addressRepo;
    private UserRepo userRepo;

    public AddressService(AddressRepo addressRepo, UserRepo userRepo) {
        this.addressRepo = addressRepo;
        this.userRepo = userRepo;
    }

    public List<Address> getAllAddresses() {
        return (List<Address>) this.addressRepo.findAll();
    }

    public Address getAddress(Long userId) {
        User user = this.userRepo.findById(userId).get();
        return this.addressRepo.findByUser(user);
    }

    public Address createAddress(Long userId, Address address) {
        User user = this.userRepo.findById(userId).get();
        address.setUser(user);
        return this.addressRepo.save(address);
    }

    public Address updateAddress(Long userId, Address address) {
        Address oldAddress = this.getAddress(userId);
        address.setId(address.getId());
        return this.addressRepo.save(address);
    }

    public Address deleteAddress(Long userId) {
        Address address = this.getAddress(userId);
        this.addressRepo.delete(address);
        return address;
    }

    public List<Address> deleteAllAddresses() {
        List<Address> addresses = (List<Address>) this.addressRepo.findAll();
        this.addressRepo.deleteAll();
        return addresses;
    }
}
