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
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnItemListener {
    public static final String BIKE_DETAIL_KEY = "bike";

    private ScrollView svMainActivity;
    private RecyclerView rvTopPicks;
    private RecyclerView.LayoutManager topPicksLayoutManager;
    private RecyclerAdapter topPicksAdapter;
    private LinearLayoutManager topPicksHorizontalLayout;

    @Override
    protected void onStart() {
        super.onStart();

        // When we restart the MainActivity, we need to sort the TopMotorbikeList to check for any
        // changes in times viewed
        TopMotorbikeList.getInstance().sortBikeList();

        // We then update the RecyclerView in MainActivity to show the new changes (if any)
        updateTopPicks();

        // Return to the top of the MainActivity
        svMainActivity.scrollTo(0,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Home Screen");

        svMainActivity = (ScrollView) findViewById(R.id.svMainActivity);

        // Find the RecyclerView for our top picks and initialise it
        rvTopPicks = (RecyclerView) findViewById(R.id.rvTopPicks);
        initialiseTopPicks();

        // Find Card Views on the home screen, connect them to their onClick handlers
        CardView cruisersCategory = (CardView) findViewById(R.id.cvCruisersCategory);
        cruisersCategory.setOnClickListener(cruisersCategoryHandler);

        CardView roadstersCategory = (CardView) findViewById(R.id.cvRoadstersCategory);
        roadstersCategory.setOnClickListener(roadstersCategoryHandler);

        CardView sportbikesCategory = (CardView) findViewById(R.id.cvSportbikesCategory);
        sportbikesCategory.setOnClickListener(sportbikesCategoryHandler);

        CardView nakedCategory = (CardView) findViewById(R.id.cvNakedCategory);
        nakedCategory.setOnClickListener(nakedsCategoryHandler);

        CardView adventureCategory = (CardView) findViewById(R.id.cvAdventureCategory);
        adventureCategory.setOnClickListener(adventuresCategoryHandler);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // turn off night mode
    }

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

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
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

    View.OnClickListener nakedsCategoryHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent nakedListActivity = new Intent(getBaseContext(), ListActivity.class);
            nakedListActivity.putExtra("filter", "Naked");
            startActivity(nakedListActivity);
        }
    };

    View.OnClickListener adventuresCategoryHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent adventureListActivity = new Intent(getBaseContext(), ListActivity.class);
            adventureListActivity.putExtra("filter", "Adventure");
            startActivity(adventureListActivity);
        }
    };

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

        // Sort bikes by times viewed
        TopMotorbikeList.getInstance().sortBikeList();

        // Load the bikes into the adapter
        topPicksAdapter = new RecyclerAdapter(TopMotorbikeList.getInstance().getBikeList(), this);
        rvTopPicks.setAdapter(topPicksAdapter);
    }

    private void updateTopPicks() {
        // Load the bikes from TopMotorbikeList into the adapter
        topPicksAdapter = new RecyclerAdapter(TopMotorbikeList.getInstance().getBikeList(), this);
        rvTopPicks.setAdapter(topPicksAdapter);
    }

    @Override
    public void onItemClick(int position) {
        // Increment the number of views for the selected bike, in TopMotorbikeList
        TopMotorbikeList.getInstance().updateTimesViewed(TopMotorbikeList.getInstance().getBikeList().get(position).getModel());

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(BIKE_DETAIL_KEY, TopMotorbikeList.getInstance().getBikeList().get(position));

        startActivity(intent);
    }
}