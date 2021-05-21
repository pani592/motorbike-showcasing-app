package com.example.motorbikeapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TopMotorbikeList {
    // Generate list of bikes
    private ArrayList<Motorbike> bikeList = MotorbikeProvider.generateData("");

    // The one instance of our TopMotorbikeList class is created, and can be accessed from other
    // activities with getInstance()
    private static final TopMotorbikeList instance = new TopMotorbikeList();
    public static TopMotorbikeList getInstance() {

        return instance;
    }

    public ArrayList<Motorbike> getBikeList() {

        return this.bikeList;
    }

    public void updateTimesViewed(String model) {
        for (int i = 0; i < bikeList.size(); i++) {

            if (bikeList.get(i).getModel() == model) {
                bikeList.get(i).incTimesViewed();
                System.out.println(model + " times viewed updated to: " + bikeList.get(i).getTimesViewed());

                break;
            }
        }
    }

    public void sortBikeList() {

        bikeList.sort(Comparator.comparing(bike -> bike.getTimesViewed()));
        Collections.reverse(bikeList);
    }

}
