package com.example.bookstore.address;

import com.example.bookstore.user.User;

import javax.persistence.*;

@Entity
//@Table(name = "\"address\"")   /* escape SQL reserved keywords */
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String houseNo;
    private String postcode;
    private String city;
    private String country;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address() {
    }

    public Address(String street, String houseNo, String postcode, String city, String country) {
        this.street = street;
        this.houseNo = houseNo;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
