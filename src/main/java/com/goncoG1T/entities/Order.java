package com.goncoG1T.entities;

import com.goncoG1T.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    Date moment;
    OrderStatus status;
    Client client;
    List<OrderItem> items;

    public Order(){
        this.moment = new Date();
        this.client = new Client();
        this.items = new ArrayList<>();
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public void addItems(OrderItem orderItem){
        items.add(orderItem);
    }

    public void removeItems(OrderItem orderItem){
        items.remove(orderItem);
    }

    public Double total(){
        double total = 0;
        for (OrderItem orderItem: items) {
            total += orderItem.subTotal();
        }
        return total;
    }

    @Override
    public String toString() {

        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: "+ sfd.format(moment)+"\n");
        sb.append("Order status: "+status.toString()+"\n");
        sb.append("Client: "+client.toString());

        for (OrderItem orderItem:items) {
            sb.append("\n"+orderItem.getProduct().getName());
            sb.append(", $" + orderItem.getProduct().getPrice());
            sb.append(", Quantity: " + orderItem.getQuantity());
            sb.append(String.format(", Subtotal: $%.2f", orderItem.subTotal()));
        }
        sb.append(String.format("\nTotal price: $%.2f", total()));
        return sb.toString();
    }

}
