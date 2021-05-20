package com.example.motorbikeapp;

import java.util.ArrayList;

public class MotorbikeProvider {
    static String[] models = {"Meteor 350", "CMX500 Rebel", "Vulcan S", "CMX1100 Rebel", "Scout 1200", "Softail Slim", "X-Diavel","R18", "Rocket 3", "Vintage Dark Horse",
            "Interceptor 650", "XSR700", "V7 Sport", "Street Twin", "CB1100EX", "Z900RS", "Bonneville T120", "R nineT Pure", "FTR", "Scrambler 1100 Sport Pro",
            "RS 125 GP Replica", "RC 390", "Ninja 650", "RS660", "S1000RR", "ZX-10R", "GSX-R1000R", "YZF-R1", "CBR1000RR-R Fireblade", "Panigale V4S", };

    static double[] prices = {3749, 5799, 6699, 8999 , 11899, 16495 , 16995, 18995, 20000, 21399,
            5699,7699,8000,8200,9799,10649,10800,11395,12295,12795,
            4599,5299,6899,10150,15590,15799,16999,17399,19999,24995};

    static String[] companies = {"Royal Enfield", "Honda", "Kawasaki", "Honda", "Indian", "Harley-Davidson", "Ducati", "BMW", "Triumph", "Indian",
            "Royal Enfield", "Yamaha", "Moto Guzzi", "Triumph", "Honda", "Kawasaki" , "Triumph", "BMW", "Indian", "Ducati",
            "Aprilia", "KTM", "Kawasaki", "Aprilia", "BMW", "Kawasaki", "Suzuki", "Yamaha", "Honda", "Ducati"};

    static String[] categories = {"Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser", "Cruiser",
            "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster",
            "Sportbike", "Sportbike", "Sportbike", "Sportbike", "Sportbike","Sportbike", "Sportbike", "Sportbike","Sportbike","Sportbike"};

    //image path of bike images in the drawable folder
    static int[] imageaddrs = {R.drawable.mc001a, R.drawable.mc002a,R.drawable.mc003a,R.drawable.mc004a,R.drawable.mc005a,R.drawable.mc006a,
            R.drawable.mc007a,R.drawable.mc008a,R.drawable.mc009a, R.drawable.mc010a,
            R.drawable.mr001a, R.drawable.mr002a, R.drawable.mr003a, R.drawable.mr004a, R.drawable.mr005a,
            R.drawable.mr006a, R.drawable.mr007a, R.drawable.mr008a, R.drawable.mr009a, R.drawable.mr010a,
            R.drawable.ms001a, R.drawable.ms002a, R.drawable.ms003a, R.drawable.ms004a, R.drawable.ms005a,
            R.drawable.ms006a, R.drawable.ms007a, R.drawable.ms008a, R.drawable.ms009a, R.drawable.ms010a};

    public static ArrayList<Motorbike> generateData(String filter) {
        ArrayList<Motorbike> bikes = new ArrayList<Motorbike>();

        for (int i = 0; i < models.length; i++) {
            String model = models[i];
            String company = companies[i];
            double price = prices[i];
            String category =  categories[i];
            int imageaddr = imageaddrs[i];

            String s = filter.toLowerCase();

            if (category.toLowerCase().contains(s) || model.toLowerCase().contains(s) || company.toLowerCase().contains(s)) {
                Motorbike aBike = new Motorbike(model, price, company, category, imageaddr);
                bikes.add(aBike);
            }
        }
        return bikes;
    }
}


