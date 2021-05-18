package com.example.motorbikeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivMotorbikeImage;
    private TextView tvModel;
    private TextView tvCompany;
    private TextView tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivMotorbikeImage = (ImageView) findViewById(R.id.ivMotorbikeImage);
        tvModel = (TextView) findViewById(R.id.tvModel);
        tvCompany = (TextView) findViewById(R.id.tvCompany);
        tvPrice = (TextView) findViewById(R.id.tvPrice);

        // Get the bike that was passed from the Intent of the ListActivity
        Intent thisIntent = getIntent();
        Motorbike bike = (Motorbike) thisIntent.getSerializableExtra(ListActivity.BIKE_DETAIL_KEY);

        // Load the data from the bike into the DetailView
        loadBike(bike);
    }

    private void loadBike(Motorbike bike) {
        // Change activity title
        this.setTitle(bike.getModel());

        // Set item details
        tvModel.setText(bike.getModel());
        tvCompany.setText(bike.getCompany());

        String truncatedPrice = String.valueOf(bike.getPrice());
        truncatedPrice = truncatedPrice.substring(0, truncatedPrice.length() - 2);

        tvPrice.setText('$' + truncatedPrice);
        int resID = bike.getImage();
        ivMotorbikeImage.setImageResource(resID);
    }
}