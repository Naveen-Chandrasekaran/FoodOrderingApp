package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {
    String[] names;
    int[] images,price;
    Context context;
    LayoutInflater inflater;

    public CustomListAdapter(String[] names, int[] price, int[] images, Context context) {
        this.names = names;
        this.price = price;
        this.images = images;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.list_design,null);

        ImageView imageView=(ImageView) view.findViewById(R.id.list_image);
        TextView textView=(TextView) view.findViewById(R.id.list_name);
        TextView txt_price=(TextView) view.findViewById(R.id.list_price);

        imageView.setBackgroundResource(images[i]);
        textView.setText(names[i]);
        if(price[i]!=0){
            txt_price.setText("Rs. "+price[i]);
        }
        else {
            txt_price.setText(" ");
        }
        return view;
    }
}
