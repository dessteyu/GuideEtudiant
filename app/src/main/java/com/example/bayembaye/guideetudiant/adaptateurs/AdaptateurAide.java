package com.example.bayembaye.guideetudiant.adaptateurs;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bayembaye.guideetudiant.Drivers.Drivers;
import com.example.bayembaye.guideetudiant.R;

/**
 * Created by bayembaye on 31/10/2016.
 */
public class AdaptateurAide extends ArrayAdapter<String> {

    public AdaptateurAide(Context context, String[] objects) {
        super(context, R.layout.aide_row, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.aide_row, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.aideText);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.aideImg);

        textView.setText(getItem(position));
        
        if(convertView == null )
            imageView.setImageResource(Drivers.TAB_IMG[position]);
        else
            rowView = (View)convertView;
        return rowView;
    }
}
