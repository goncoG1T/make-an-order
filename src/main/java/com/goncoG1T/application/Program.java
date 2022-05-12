package com.goncoG1T.application;

import com.goncoG1T.entities.Order;
import com.goncoG1T.entities.OrderItem;
import com.goncoG1T.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String [] args) throws ParseException {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        Order order  = new Order();
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("\nEnter client data below");
        System.out.print("Name: ");
        String typedName = sc.nextLine();
        order.getClient().setName(typedName);

        System.out.print("Email: ");
        order.getClient().setEmail(sc.nextLine());

        System.out.print("Birth date (DD/MM/YYYY): ");
        order.getClient().setBirthDate(sfd.parse(sc.nextLine()));

        System.out.println("\nEnter order data below");
        System.out.print("Possible status: ");

        for (OrderStatus possibleStatus : OrderStatus.values()) {

            if(possibleStatus == OrderStatus.DELIVERED){
                System.out.print(possibleStatus.toString());
            }else{
                System.out.print(possibleStatus.toString()+" - ");
            }
        }


        System.out.print("\nStatus: ");
        order.setStatus(OrderStatus.valueOf(sc.nextLine()));

        System.out.print("\nHow many items to this order? ");
        int quantity = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantity; i++) {
            OrderItem orderItem = new OrderItem();

            System.out.println("\nEnter #"+(i+1)+" item data:");
            System.out.print("Product name: ");
            orderItem.getProduct().setName(sc.nextLine());

            System.out.print("Product price: ");
            orderItem.getProduct().setPrice(sc.nextDouble());

            System.out.print("Quantity: ");
            orderItem.setQuantity(sc.nextInt());
            order.addItems(orderItem);
            sc.nextLine();
        }

        System.out.println("\nORDER SUMMARY:");
        System.out.println(order.toString());
    }
}
