package com.example.rajat.diwalidhamaka;

import java.io.Serializable;

/**
 * Created by Rajat on 10/18/2017.
 */

public class ItemDetail implements Serializable{
    private final String Id;
    private final String Pname;
    private int Qty;
    private final double Price;
    public ItemDetail(String id, String pname, int qty, double price) {
        Id = id;
        Pname = pname;
        Qty = qty;
        Price = price;
    }
    public String getId() {
        return Id;
    }

    public String getPname() {
        return Pname;
    }

    public int getQty() {
        return Qty;
    }

    public double getPrice() {
        return Price;
    }

    public void changeQty(int val) { Qty=val; }

    @Override
    public String toString() {
        return Id+Pname;
    }
}
