package com.example.motorbikeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MotorbikeAdapter extends ArrayAdapter<Motorbike> {

    private static class ViewHolder {
        public ImageView ivMotorbikeImage;
        public TextView tvModel, tvCompany, tvCategory, tvPrice;
    }

    public MotorbikeAdapter(Context context, ArrayList<Motorbike> aBikes) {
        super(context, 0, aBikes);
    }

    //translates a particular 'Motorbike' given a position
    //into a relevant row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the data item for this position
        final Motorbike bike = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_motorbike,parent,false);

            viewHolder.ivMotorbikeImage =
                    (ImageView)convertView.findViewById(R.id.ivMotorbikeImage);
            viewHolder.tvModel =
                    (TextView)convertView.findViewById(R.id.tvModel);
            viewHolder.tvCategory =
                    (TextView)convertView.findViewById(R.id.tvCategory);
            convertView.setTag(viewHolder);
            viewHolder.tvCompany =
                    (TextView)convertView.findViewById(R.id.tvCompany);
            viewHolder.tvPrice =
                    (TextView)convertView.findViewById(R.id.tvPrice);
            convertView.setTag(viewHolder);

        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the data into the template view using the data object
        viewHolder.tvModel.setText(bike.getModel());
        viewHolder.tvCompany.setText(bike.getCompany());
        viewHolder.tvCategory.setText(bike.getCategory());
        viewHolder.tvPrice.setText('$' + (String.valueOf(bike.getPrice())));
        int resID = bike.getImage();
        viewHolder.ivMotorbikeImage.setImageResource(resID);
        return convertView;
    }
}
