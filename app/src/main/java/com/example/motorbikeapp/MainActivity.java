package com.example.motorbikeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // turn off night mode
    }

    View.OnClickListener cruisersCategoryHandler = new View.OnClickListener() {
        public void onClick(View view) {

            Intent cruisersListActivity = new Intent(getBaseContext(), ListActivity.class);
            cruisersListActivity.putExtra("filter", "Cruiser");

            startActivity(cruisersListActivity);
        }
    };

    View.OnClickListener roadstersCategoryHandler = new View.OnClickListener() {
        public void onClick(View view) {

            Intent roadstersListActivity = new Intent(getBaseContext(), ListActivity.class);
            roadstersListActivity.putExtra("filter", "Roadster");

            startActivity(roadstersListActivity);
        }
    };

    View.OnClickListener sportbikesCategoryHandler = new View.OnClickListener() {
        public void onClick(View view) {

            Intent sportbikesListActivity = new Intent(getBaseContext(), ListActivity.class);
            sportbikesListActivity.putExtra("filter", "Sportbike");

            startActivity(sportbikesListActivity);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();
                //complete SearchActivity by yourself
                Intent searchActivity = new Intent(getBaseContext(), ListActivity.class);
                searchActivity.putExtra("filter", query);
                startActivity(searchActivity);

                // Set activity title to search query
                //MainActivity.this.setTitle(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }
}