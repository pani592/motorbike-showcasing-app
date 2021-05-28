package com.example.motorbikeapp;

import java.util.ArrayList;
import java.util.List;

public class MotorbikeProvider {
    static String[] models = {"Meteor 350", "CMX500 Rebel", "Vulcan S", "CMX1100 Rebel", "Scout 1200", "Softail Slim", "X-Diavel","R18", "Rocket 3", "Vintage Dark Horse",
            "Interceptor 650", "XSR700", "V7 Sport", "Street Twin", "CB1100EX", "Z900RS", "Bonneville T120", "R nineT Pure", "FTR", "Scrambler 1100 Sport Pro",
            "RS 125 GP Replica", "RC 390", "Ninja 650", "RS660", "S1000RR", "ZX-10R", "GSX-R1000R", "YZF-R1", "CBR1000RR-R Fireblade", "Panigale V4S",
            "SV650","Z650","MT-07","Trident 660","CB650R","GSX-S750","F900R","Street Triple R","Duke 890","Monster",
            "TRK502","CB500X","Versys 650","V-Strom 650 XT","Tenere 700","F850GSA","V85 TT","Adventure 890","Tiger 900","Multistrada 950 S"};

    static double[] prices = {3749, 5799, 6699, 8999 , 11899, 16495 , 16995, 18995, 20000, 21399,
            5699,7699,8000,8200,9799,10649,10800,11395,12295,12795,
            4599,5299,6899,10150,15590,15799,16999,17399,19999,24995,
            6499,6849,6899,7195,7299,7999,8660,9100,9649,10295,
            5299,6119,7549,8299,9499,11105,11200,10999,11400,13795};

    static String[] companies = {"Royal Enfield", "Honda", "Kawasaki", "Honda", "Indian", "Harley Davidson", "Ducati", "BMW", "Triumph", "Indian",
            "Royal Enfield", "Yamaha", "Moto Guzzi", "Triumph", "Honda", "Kawasaki" , "Triumph", "BMW", "Indian", "Ducati",
            "Aprilia", "KTM", "Kawasaki", "Aprilia", "BMW", "Kawasaki", "Suzuki", "Yamaha", "Honda", "Ducati",
            "Suzuki","Kawasaki","Yamaha","Triumph","Honda","Suzuki","BMW","Triumph","KTM","Ducati",
            "Benelli","Honda","Kawasaki","Suzuki","Yamaha","BMW","Moto Guzzi","KTM","Triumph","Ducati"};

    static String[] categories = {"Cruiser","Cruiser","Cruiser","Cruiser","Cruiser","Cruiser","Cruiser","Cruiser","Cruiser","Cruiser",
            "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster", "Roadster",
            "Sportbike", "Sportbike", "Sportbike", "Sportbike", "Sportbike","Sportbike", "Sportbike", "Sportbike","Sportbike","Sportbike",
            "Naked","Naked","Naked","Naked","Naked","Naked","Naked","Naked","Naked","Naked",
            "Adventure","Adventure","Adventure","Adventure","Adventure","Adventure","Adventure","Adventure","Adventure","Adventure"};

    static int[] imageaddrs = {R.drawable.mc001a, R.drawable.mc001b, R.drawable.mc001c,R.drawable.mc001d,
            R.drawable.mc002a, R.drawable.mc002b, R.drawable.mc002c,R.drawable.mc002d,
            R.drawable.mc003a, R.drawable.mc003b, R.drawable.mc003c,R.drawable.mc003d,
            R.drawable.mc004a,R.drawable.mc004b, R.drawable.mc004c,R.drawable.mc004d,
            R.drawable.mc005a,R.drawable.mc005b, R.drawable.mc005c,R.drawable.mc005d,
            R.drawable.mc006a,R.drawable.mc006b, R.drawable.mc006c,R.drawable.mc006d,
            R.drawable.mc007a,R.drawable.mc007b, R.drawable.mc007c,R.drawable.mc007d,
            R.drawable.mc008a,R.drawable.mc008b, R.drawable.mc008c,R.drawable.mc008d,
            R.drawable.mc009a, R.drawable.mc009b, R.drawable.mc009c,R.drawable.mc009d,
            R.drawable.mc010a,R.drawable.mc010b, R.drawable.mc010c,R.drawable.mc010d,

            R.drawable.mr001a, R.drawable.mr001b, R.drawable.mr001c,R.drawable.mr001d,
            R.drawable.mr002a, R.drawable.mr002b, R.drawable.mr002c,R.drawable.mr002d,
            R.drawable.mr003a, R.drawable.mr003b, R.drawable.mr003c,R.drawable.mr003d,
            R.drawable.mr004a,R.drawable.mr004b, R.drawable.mr004c,R.drawable.mr004d,
            R.drawable.mr005a,R.drawable.mr005b, R.drawable.mr005c,R.drawable.mr005d,
            R.drawable.mr006a,R.drawable.mr006b, R.drawable.mr006c,R.drawable.mr006d,
            R.drawable.mr007a,R.drawable.mr007b, R.drawable.mr007c,R.drawable.mr007d,
            R.drawable.mr008a,R.drawable.mr008b, R.drawable.mr008c,R.drawable.mr008d,
            R.drawable.mr009a, R.drawable.mr009b, R.drawable.mr009c,R.drawable.mr009d,
            R.drawable.mr010a,R.drawable.mr010b, R.drawable.mr010c,R.drawable.mr010d,

            R.drawable.ms001a, R.drawable.ms001b, R.drawable.ms001c,R.drawable.ms001d,
            R.drawable.ms002a, R.drawable.ms002b, R.drawable.ms002c,R.drawable.ms002d,
            R.drawable.ms003a, R.drawable.ms003b, R.drawable.ms003c,R.drawable.ms003d,
            R.drawable.ms004a,R.drawable.ms004b, R.drawable.ms004c,R.drawable.ms004d,
            R.drawable.ms005a,R.drawable.ms005b, R.drawable.ms005c,R.drawable.ms005d,
            R.drawable.ms006a,R.drawable.ms006b, R.drawable.ms006c,R.drawable.ms006d,
            R.drawable.ms007a,R.drawable.ms007b, R.drawable.ms007c,R.drawable.ms007d,
            R.drawable.ms008a,R.drawable.ms008b, R.drawable.ms008c,R.drawable.ms008d,
            R.drawable.ms009a, R.drawable.ms009b, R.drawable.ms009c,R.drawable.ms009d,
            R.drawable.ms010a,R.drawable.ms010b, R.drawable.ms010c,R.drawable.ms010d,

            R.drawable.md001a, R.drawable.md001b, R.drawable.md001c,R.drawable.md001d,
            R.drawable.md002a, R.drawable.md002b, R.drawable.md002c,R.drawable.md002d,
            R.drawable.md003a, R.drawable.md003b, R.drawable.md003c,R.drawable.md003d,
            R.drawable.md004a,R.drawable.md004b, R.drawable.md004c,R.drawable.md004d,
            R.drawable.md005a,R.drawable.md005b, R.drawable.md005c,R.drawable.md005d,
            R.drawable.md006a,R.drawable.md006b, R.drawable.md006c,R.drawable.md006d,
            R.drawable.md007a,R.drawable.md007b, R.drawable.md007c,R.drawable.md007d,
            R.drawable.md008a,R.drawable.md008b, R.drawable.md008c,R.drawable.md008d,
            R.drawable.md009a, R.drawable.md009b, R.drawable.md009c,R.drawable.md009d,
            R.drawable.md010a,R.drawable.md010b, R.drawable.md010c,R.drawable.md010d,

            R.drawable.ma001a, R.drawable.md001b, R.drawable.md001c,R.drawable.md001d, // will update images later.
            R.drawable.ma002a, R.drawable.md002b, R.drawable.md002c,R.drawable.md002d,
            R.drawable.ma003a, R.drawable.md003b, R.drawable.md003c,R.drawable.md003d,
            R.drawable.ma004a,R.drawable.md004b, R.drawable.md004c,R.drawable.md004d,
            R.drawable.ma005a,R.drawable.md005b, R.drawable.md005c,R.drawable.md005d,
            R.drawable.ma006a,R.drawable.md006b, R.drawable.md006c,R.drawable.md006d,
            R.drawable.ma007a,R.drawable.md007b, R.drawable.md007c,R.drawable.md007d,
            R.drawable.ma008a,R.drawable.md008b, R.drawable.md008c,R.drawable.md008d,
            R.drawable.ma009a, R.drawable.md009b, R.drawable.md009c,R.drawable.md009d,
            R.drawable.ma010a,R.drawable.md010b, R.drawable.md010c,R.drawable.md010d};

    public static ArrayList<Motorbike> generateData(String filter) {
        ArrayList<Motorbike> bikes = new ArrayList<Motorbike>();

        for (int i = 0; i < models.length; i++) {
            String model = models[i];
            String company = companies[i];
            double price = prices[i];
            String category =  categories[i];
            int imageaddr = imageaddrs[i*4];

            if (filter != ""){
                String s = filter.toLowerCase();

                if (category.toLowerCase().contains(s) || model.toLowerCase().contains(s) || company.toLowerCase().contains(s)) {
                    Motorbike aBike = new Motorbike(model, price, company, category, imageaddr, i);
                    bikes.add(aBike);
                }

            } else {
                Motorbike aBike = new Motorbike(model, price, company, category, imageaddr, i);
                bikes.add(aBike);
            }

        }
        return bikes;
    }

    public static List<ImageSlider> generateImages(int positionID) {
        List<ImageSlider> sliderItems = new ArrayList<>();
        for (int i = 0; i<4; i++){
            sliderItems.add(new ImageSlider(imageaddrs[4*positionID + i]));
        }
        return sliderItems;
    }
}


