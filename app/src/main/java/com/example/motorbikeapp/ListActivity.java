package com.example.motorbikeapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent thisIntent = getIntent();
        String filter = thisIntent.getStringExtra("filter");
        this.setTitle(filter);

        lvMotorbikes = (ListView) findViewById(R.id.lvMotorbikes);
        lvMotorbikes.setEmptyView(findViewById(R.id.tv_emptyTextView));
        ArrayList<Motorbike> aBikes = new ArrayList<Motorbike>();
        aBikes = MotorbikeProvider.generateData(filter);

        bikeAdapter = new MotorbikeAdapter(this, aBikes);
        lvMotorbikes.setAdapter(bikeAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupMotorbikeSelectedListener();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupMotorbikeSelectedListener() {
        lvMotorbikes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {

                // Increment the number of views for the selected bike, in TopMotorbikeList
                TopMotorbikeList.getInstance().updateTimesViewed(bikeAdapter.getItem(position).getModel());

                // Launch the detail view passing a bike as an extra
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra(BIKE_DETAIL_KEY, bikeAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}