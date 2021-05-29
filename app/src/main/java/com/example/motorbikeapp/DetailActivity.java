package com.example.motorbikeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private Motorbike bike;

    private ScrollView svDetailActivity;
    private TextView tvModel;
    private TextView tvCompany;
    private TextView tvPrice;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private TextView tvDescription;
    private Button btShowMore;

    private Handler slideHandler = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        svDetailActivity = (ScrollView) findViewById(R.id.svDetailActivity);
        tvModel = (TextView) findViewById(R.id.tvModel);
        tvCompany = (TextView) findViewById(R.id.tvCompany);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        viewPager2 = (ViewPager2) findViewById(R.id.viewPagerImageSlider);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        btShowMore = (Button) findViewById(R.id.btShowMore);

        // Get the bike that was passed from the Intent of the ListActivity
        Intent thisIntent = getIntent();
        this.bike = (Motorbike) thisIntent.getSerializableExtra(ListActivity.BIKE_DETAIL_KEY);

        // Load the data from the bike into the DetailView
        loadBike(bike);

        // Create the mediator that allows the TabLayout index and ViewPager2 index to sync
        TabLayoutMediator tabLayoutMediator =
                new TabLayoutMediator(tabLayout, viewPager2, true,
                        new TabLayoutMediator.TabConfigurationStrategy() {
                            @Override public void onConfigureTab(
                                    @NonNull TabLayout.Tab tab, int position) { }
                        }
                );
        tabLayoutMediator.attach();
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

    private void loadBike(Motorbike bike) {
        // Change activity title
        this.setTitle(bike.getModel());

        // Set item details
        tvModel.setText(bike.getModel());
        tvCompany.setText(bike.getCompany());

        String truncatedPrice = String.valueOf(bike.getPrice());
        truncatedPrice = truncatedPrice.substring(0, truncatedPrice.length() - 2);

        tvPrice.setText('$' + truncatedPrice);

        int positionID = bike.getBikePositionID();
        List<ImageSlider> sliderItems = MotorbikeProvider.generateImages(positionID);
        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(sliderItems.size() - 1);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(slideRunnable);
                slideHandler.postDelayed(slideRunnable, 3000); // slide duration 3 seconds
            }
        });

        tvDescription.setText(getBikeDescription(bike, false));
        btShowMore.setOnClickListener(showMoreButtonHandler);
    }

    private Runnable slideRunnable = new Runnable(){
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() < (viewPager2.getAdapter().getItemCount() - 1)) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            } else {
                viewPager2.setCurrentItem(0);
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(slideRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        slideHandler.postDelayed(slideRunnable, 3000);
    }

    View.OnClickListener showMoreButtonHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // Changing text based on click
            if (btShowMore.getText().equals("Show more")) {

                btShowMore.setText("Show less");
                tvDescription.setBackgroundResource(0);
                tvDescription.setBackgroundColor(-1);
                tvDescription.setText(getBikeDescription(bike, true));

                // When the show more button is clicked, scroll to the bottom of the screen
                svDetailActivity.post(new Runnable() {
                    @Override
                    public void run() {
                        svDetailActivity.smoothScrollTo(0, (int) tvDescription.getTop());
                    }
                });
            } else {

                btShowMore.setText("Show more");
                tvDescription.setBackgroundResource(R.drawable.text_gradient);
                tvDescription.setText(getBikeDescription(bike, false));
            }
        }
    };

    private String getBikeDescription(Motorbike bike, boolean fullLength) {

        String parsedModelName = bike.getModel();
        parsedModelName = parsedModelName.replaceAll(" ", ""); // Replace spaces with nothing
        parsedModelName = parsedModelName.replaceAll("-", ""); // Replace hyphens with nothing

        int resID = getResources().getIdentifier(parsedModelName, "string", getApplicationContext().getPackageName());
        String motorbikeDescription = (String) getString(resID);

        // If the full length description is not wanted, only slice if length is >200
        if (!fullLength && motorbikeDescription.length() > 200) {
            motorbikeDescription = motorbikeDescription.substring(0, 199) + "...";
        }

        return motorbikeDescription;
    }
}