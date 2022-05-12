package com.goncoG1T.entities;

public class OrderItem {
    Integer quantity;
    Double price;

    Product product;

    public OrderItem(){
        this.quantity = null;
        this.price = null;
        this.product = new Product();
    }

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal(){
        return quantity* product.getPrice();
    }
}
