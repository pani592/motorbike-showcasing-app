package com.example.motorbikeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MotorbikeRecyclerAdapter extends RecyclerView.Adapter<MotorbikeRecyclerAdapter.ViewHolder>
{
    private ArrayList<Motorbike> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivMotorbikeImage;
        private final TextView tvModelName;
        private final TextView tvTimesViewed;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            ivMotorbikeImage = (ImageView) view.findViewById(R.id.ivMotorbikeImage);
            tvModelName = (TextView) view.findViewById(R.id.tvModelName);
            tvTimesViewed = (TextView) view.findViewById(R.id.tvTimesViewed);

        }

        public ImageView getIvMotorbikeImage() { return ivMotorbikeImage; }
        public TextView getTvModelName() { return tvModelName; }
        public TextView getTvTimesViewed() { return tvTimesViewed; }
    }

    // Initialize the dataset of the adapter
    public MotorbikeRecyclerAdapter(ArrayList<Motorbike> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_top_motorbike, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTvModelName().setText(localDataSet.get(position).getModel());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}