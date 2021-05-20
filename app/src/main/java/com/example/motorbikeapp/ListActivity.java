package com.example.motorbikeapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    public static final String BIKE_DETAIL_KEY = "bike";
    ListView lvMotorbikes;
    MotorbikeAdapter bikeAdapter;
    ArrayList<Motorbike> aBikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent thisIntent = getIntent();
        String filter = thisIntent.getStringExtra("filter");
        this.setTitle(filter);

        lvMotorbikes = (ListView) findViewById(R.id.lvMotorbikes);
        ArrayList<Motorbike> aBikes = new ArrayList<Motorbike>();
        aBikes = MotorbikeProvider.generateData(filter);

        bikeAdapter = new MotorbikeAdapter(this, aBikes);
        lvMotorbikes.setAdapter(bikeAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupMotorbikeSelectedListener();
    }

    public void setupMotorbikeSelectedListener() {
        lvMotorbikes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {

                // Launch the detail view passing a bike as an extra
                Intent intent = new Intent(ListActivity.this,
                        DetailActivity.class);
                intent.putExtra(BIKE_DETAIL_KEY, bikeAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }
}