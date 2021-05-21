package com.example.motorbikeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<Motorbike> aBikes;

    RecyclerView rvTopPicks;
    RecyclerView.LayoutManager topPicksLayoutManager;
    MotorbikeRecyclerAdapter topPicksAdapter;
    LinearLayoutManager topPicksHorizontalLayout;

    public static void updateTimesViewed(String model) {
        for (int i = 0; i < aBikes.size(); i++){

            if (aBikes.get(i).getModel() == model) {
                aBikes.get(i).incTimesViewed();
                System.out.println(model + " times viewed updated to: " +aBikes.get(i).getTimesViewed());

                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Home Screen");

        // Create the list of 30 bikes
        aBikes = MotorbikeProvider.generateData("");

        // Find the RecyclerView for our top picks and initialise it
        rvTopPicks = findViewById(R.id.rvTopPicks);
        initialiseTopPicks();

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

                // Start search with filter
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

    private void initialiseTopPicks() {
        // Set layout manager for rvTopPicks
        topPicksLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvTopPicks.setLayoutManager(topPicksLayoutManager);

        // Set horizontal layout manager for rvTopPicks
        topPicksHorizontalLayout = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        rvTopPicks.setLayoutManager(topPicksHorizontalLayout);

        // Load the bikes into the adapter
        topPicksAdapter = new MotorbikeRecyclerAdapter(aBikes);
        rvTopPicks.setAdapter(topPicksAdapter);
    }
}