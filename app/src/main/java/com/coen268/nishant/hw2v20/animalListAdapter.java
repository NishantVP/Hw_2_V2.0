package com.coen268.nishant.hw2v20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nishant on 1/27/2015.
 */
public class animalListAdapter extends BaseAdapter{

    // Declare Variables
    public Context context;
    public String[] animals;
    public int[] pics;
    public LayoutInflater inflater;
    public TextView name;
    public ImageView pic;

    public animalListAdapter(Context context, String[] animalsip, int[] picsip) {
        this.context = context;
        this.animals = animalsip;
        this.pics = picsip;
    }

    @Override
    public int getCount() {
        return animals.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_item, parent, false);

        name = (TextView) itemView.findViewById(R.id.listItemTextView);
        pic = (ImageView) itemView.findViewById(R.id.listItemImageView);

        name.setText(animals[position]);
        pic.setImageResource(pics[position]);

        return itemView;
    }
}
