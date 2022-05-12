package com.goncoG1T.entities;

public class Product {
    private String name;
    private Double price;

    public Product(){
        this.name = null;
        this.price = null;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
