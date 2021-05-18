package com.example.motorbikeapp;

import java.util.ArrayList;

public class MotorbikeProvider {
    static String[] models = {"Meteor 350", "CMX500 Rebel", "Vulcan S", "CMX1100 Rebel", "Scout 1200", "Softail Slim", "X-Diavel","R18", "Rocket 3", "Vintage Dark Horse",
            "Interceptor 650",
            "RS 125 GP Replica"};

    static double[] prices = {3749, 5799, 6699, 8999 , 11899, 16495 , 16995, 18995, 20000, 21399,
            5699,
            4599};

    static String[] companies = {"Royal Enfield", "Honda", "Kawasaki ", "Honda ", "Indian ", "Harley-Davidson", "Ducati", "BMW", "Triumph", "Indian",
            "Royal Enfield",
            "Aprilia"};

    static String[] categories = {"Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser",
            "Roadster",
            "Sportbike"};

    //image path of bike images in the drawable folder
    static int[] imageaddrs = {R.drawable.mc001a, R.drawable.mc002a,R.drawable.mc003a,R.drawable.mc004a,R.drawable.mc005a,R.drawable.mc006a,
            R.drawable.mc007a,R.drawable.mc008a,R.drawable.mc009a, R.drawable.mc010a,
            R.drawable.mr001a,
            R.drawable.ms001a,};

    public static ArrayList<Motorbike> generateData(String categoryName) {
        ArrayList<Motorbike> bikes = new ArrayList<Motorbike>();

        for (int i = 0; i < models.length; i++) {
            String model = models[i];
            String company = companies[i];
            double price = prices[i];
            String category =  categories[i];
            int imageaddr = imageaddrs[i];

            if (categoryName.contains(categories[i])) {
                Motorbike aBike = new Motorbike(model, price, company, category, imageaddr);
                bikes.add(aBike);
            }
        }
        return bikes;
    }
}


