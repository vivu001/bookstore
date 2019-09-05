package com.example.bookstore.store;

import com.example.bookstore.stock.Stock;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String s_name;
    private String street;
    private String house_no;
    private String city;
    private String postcode;
    private String tel;
    private int capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE)
    private Set<Stock> stockQuantities;

    public Store() {
    }

    public Store(String s_name, String street, String house_no, String city, String postcode, String tel, int capacity) {
        this.s_name = s_name;
        this.street = street;
        this.house_no = house_no;
        this.city = city;
        this.postcode = postcode;
        this.tel = tel;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String haus_no) {
        this.house_no = haus_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Stock> getStockQuantities() {
        return stockQuantities;
    }

    public void setStockQuantities(Set<Stock> stockQuantities) {
        this.stockQuantities = stockQuantities;
    }
}
