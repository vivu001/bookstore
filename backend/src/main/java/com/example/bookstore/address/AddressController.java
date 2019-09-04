package com.example.bookstore.address;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return this.addressService.getAllAddresses();
    }

    @GetMapping("/{userId}/address")
    public Address getAddress(@PathVariable Long userId) {
        return this.addressService.getAddress(userId);
    }

    @PostMapping("/{userId}/address")
    public Address createAddress(@PathVariable Long userId, @RequestBody Address address) {
        return this.addressService.createAddress(userId, address);
    }

    @PutMapping("/{userId}/address")
    public Address updateAddress(@PathVariable Long userId, @RequestBody Address address) {
        return this.addressService.updateAddress(userId, address);
    }

    @DeleteMapping("/{userId}/address")
    public Address deleteAddress(@PathVariable Long userId) {
        return this.addressService.deleteAddress(userId);
    }

    @DeleteMapping("/addresses")
    public List<Address> deleteAllAddresses() {
        return this.addressService.deleteAllAddresses();
    }
}
