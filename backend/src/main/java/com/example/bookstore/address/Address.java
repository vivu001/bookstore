package com.example.bookstore.address;

import com.example.bookstore.cart.Cart;
import com.example.bookstore.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"address\"")   /* escape SQL reserved keywords */
public class Address {
    @Id
    private Long id;

    private String street;
    private String houseNo;
    private String postcode;
    private String city;
    private String country;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE)
    @MapsId
    private User user;

    public Address() {
    }

    public Address(String street, String houseNo, String postcode, String city, String country, User user) {
        this.street = street;
        this.houseNo = houseNo;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
