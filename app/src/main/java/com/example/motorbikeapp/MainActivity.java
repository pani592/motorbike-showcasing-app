package com.example.motorbikeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Home Screen");

        // Find Card Views on the home screen, connect them to their onClick handlers
        CardView cruisersCategory = (CardView) findViewById(R.id.cvCruisersCategory);
        cruisersCategory.setOnClickListener(cruisersCategoryHandler);

        CardView roadstersCategory = (CardView) findViewById(R.id.cvRoadstersCategory);
        roadstersCategory.setOnClickListener(roadstersCategoryHandler);

        CardView sportbikesCategory = (CardView) findViewById(R.id.cvSportbikesCategory);
        sportbikesCategory.setOnClickListener(sportbikesCategoryHandler);
    }

    View.OnClickListener cruisersCategoryHandler = new View.OnClickListener() {
        public void onClick(View view) {

            Intent cruisersListActivity = new Intent(getBaseContext(), ListActivity.class);
            cruisersListActivity.putExtra("categoryName", "Cruisers");

            startActivity(cruisersListActivity);
        }
    };

    View.OnClickListener roadstersCategoryHandler = new View.OnClickListener() {
        public void onClick(View view) {

            Intent roadstersListActivity = new Intent(getBaseContext(), ListActivity.class);
            roadstersListActivity.putExtra("categoryName", "Roadsters");

            startActivity(roadstersListActivity);
        }
    };

    View.OnClickListener sportbikesCategoryHandler = new View.OnClickListener() {
        public void onClick(View view) {

            Intent sportbikesListActivity = new Intent(getBaseContext(), ListActivity.class);
            sportbikesListActivity.putExtra("categoryName", "Sportbikes");

            startActivity(sportbikesListActivity);
        }
    };
}