package com.sumrid_k.Bill.Service.bill_service.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private ArrayList<Product> productId;
    private int amount;
    private double totalPrice;
    private String companyName;

    public Bill(Date date, int id, ArrayList<Product> productId, int amount, double totalPrice, String companyName) {
        this.date = date;
        this.id = id;
        this.productId = productId;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.companyName = companyName;
    }

    public Bill() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProductId() {
        return productId;
    }

    public void setProductId(ArrayList<Product> productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
