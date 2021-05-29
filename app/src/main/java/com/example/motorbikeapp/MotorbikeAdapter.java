package com.example.motorbikeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MotorbikeAdapter extends ArrayAdapter<Motorbike> {

    private static class ViewHolder {
        public ImageView ivMotorbikeImage;
        public TextView tvModel, tvCompany, tvCategory, tvPrice;
}

    public MotorbikeAdapter(Context context, ArrayList<Motorbike> aBikes) {
        super(context, 0, aBikes);
    }

    // Converts an instance of 'Motorbike' into a row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data of the bike from the position specified
        final Motorbike bike = getItem(position);

        // Check if an existing view is being reused, otherwise add the info to the view
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_motorbike, parent, false);

            viewHolder.ivMotorbikeImage = (ImageView) convertView.findViewById(R.id.ivMotorbikeImage);
            viewHolder.tvModel = (TextView) convertView.findViewById(R.id.tvModel);
            viewHolder.tvCategory = (TextView) convertView.findViewById(R.id.tvCategory);
            convertView.setTag(viewHolder);
            viewHolder.tvCompany = (TextView) convertView.findViewById(R.id.tvCompany);
            viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.tvModel.setText(bike.getModel());
        viewHolder.tvCompany.setText(bike.getCompany());
        viewHolder.tvCategory.setText(bike.getCategory());

        String truncatedPrice = String.valueOf(bike.getPrice());
        truncatedPrice = truncatedPrice.substring(0, truncatedPrice.length() - 2);
        viewHolder.tvPrice.setText('$' + truncatedPrice);

        setIVMotorbikeImage(viewHolder, bike.getImage());

        return convertView;
    }

    private void setIVMotorbikeImage(ViewHolder viewHolder, int resID) {
        Glide.with(viewHolder.ivMotorbikeImage.getContext()).load(resID).thumbnail(0.25f).override(1000, 750).into(viewHolder.ivMotorbikeImage);
    }
}
