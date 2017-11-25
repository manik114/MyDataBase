package com.mk.manik.mydatabase;

/**
 * Created by Manik on 11/20/2017.
 */

public class Products {
    private int _id;
    private String productName;

    public Products(){}

    public Products(String s){
        this.productName = s;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
