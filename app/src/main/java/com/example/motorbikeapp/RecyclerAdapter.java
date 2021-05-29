package com.example.motorbikeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<Motorbike> localDataSet;
    private OnItemListener localOnItemListener;

    // Initialize the dataset and OnItemListener of the adapter
    public RecyclerAdapter(ArrayList<Motorbike> dataSet, OnItemListener onItemListener) {
        localDataSet = dataSet;
        this.localOnItemListener = onItemListener;
    }

    // ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView ivMotorbikeImage;
        private final TextView tvModelName;
        private final TextView tvTimesViewed;

        OnItemListener onItemListener;

        public ViewHolder(View view, OnItemListener onItemListener) {
            super(view);

            ivMotorbikeImage = (ImageView) view.findViewById(R.id.ivMotorbikeImage);
            tvModelName = (TextView) view.findViewById(R.id.tvModelName);
            tvTimesViewed = (TextView) view.findViewById(R.id.tvTimesViewed);
            this.onItemListener = onItemListener;

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }

        public ImageView getIvMotorbikeImage() {
            return ivMotorbikeImage;
        }

        public TextView getTvModelName() {
            return tvModelName;
        }

        public TextView getTvTimesViewed() {
            return tvTimesViewed;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_top_motorbike, viewGroup, false);

        return new ViewHolder(view, localOnItemListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position
        Motorbike currentBike = localDataSet.get(position);

        // Replace the contents of the view with that element
        setIVMotorbikeImage(viewHolder, currentBike.getImage());

        if (currentBike.getModel().length() > 10) {
            String truncatedModel = currentBike.getModel().substring(0, 10) + "...";
            viewHolder.getTvModelName().setText(truncatedModel);
        } else {
            viewHolder.getTvModelName().setText(currentBike.getModel());
        }

        String timesViewedString;

        if (currentBike.getTimesViewed() == 1) {
            timesViewedString = currentBike.getTimesViewed() + " view";
        } else {
            timesViewedString = currentBike.getTimesViewed() + " views";
        }
        viewHolder.getTvTimesViewed().setText(timesViewedString);
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (int) localDataSet.size() / 2;
    }

    public interface OnItemListener {

        void onItemClick(int position);
    }

    private void setIVMotorbikeImage(ViewHolder viewHolder, int resID) {
        Glide.with(viewHolder.getIvMotorbikeImage().getContext()).load(resID).thumbnail(0.1f).override(400, 400).into(viewHolder.getIvMotorbikeImage());
    }
}