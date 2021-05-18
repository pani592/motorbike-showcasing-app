package com.example.motorbikeapp;

import java.io.Serializable;

public class Motorbike implements Serializable {
    private String model;
    private double price;
    private String company;
    private String category;
    private int ImageAddr;

    public Motorbike(String model, double price, String company, String category, int ImageAddr){
        this.model = model;
        this.price = price;
        this.company = company;
        this.category = category;
        this.ImageAddr = ImageAddr;
    }
    public String getModel(){
        return model;
    }
    public String getCompany(){
        return company;
    }
    public String getCategory(){
        return category;
    }
    public double getPrice() {
        return price;
    }
    public int getImage(){
        return ImageAddr;
    }
}
