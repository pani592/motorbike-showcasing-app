package com.example.motorbikeapp;

import java.io.Serializable;
import java.util.Random;

public class Motorbike implements Serializable {
    private String model;
    private double price;
    private String company;
    private String category;
    private int ImageAddr;
    private int timesViewed;
    private int bikePositionID;

    public Motorbike(String model, double price, String company, String category, int ImageAddr, int bikePositionID){
        this.model = model;
        this.price = price;
        this.company = company;
        this.category = category;
        this.ImageAddr = ImageAddr;

        Random rng = new Random();
        this.timesViewed = rng.nextInt(10);

        this.bikePositionID = bikePositionID;


    }

    public String getModel(){ return model; }
    public String getCompany(){ return company; }
    public String getCategory(){ return category; }
    public double getPrice() {
        return price;
    }
    public int getTimesViewed() { return timesViewed; }
    public int getImage(){ return ImageAddr; }

    public void incTimesViewed() { timesViewed++; }

    public int getBikePositionID() { return bikePositionID; }
}
