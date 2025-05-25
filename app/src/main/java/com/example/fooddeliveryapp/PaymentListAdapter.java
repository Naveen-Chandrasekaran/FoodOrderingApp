package com.example.fooddeliveryapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PaymentListAdapter extends BaseAdapter {
    String food_name[];
    int food_price[],quantityNum[];
    Context context;
    LayoutInflater layoutInflater;

    public PaymentListAdapter(String[] food_name, int[] food_price, int[] quantityNum,Context context) {
        this.food_name = food_name;
        this.food_price = food_price;
        this.quantityNum = quantityNum;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return food_name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.list_design_payment,null);

        TextView txt_name=(TextView) view.findViewById(R.id.payment_name);
        TextView txt_price=(TextView) view.findViewById(R.id.payment_price);
        TextView txt_quantity=(TextView) view.findViewById(R.id.payment_quantity);


          txt_name.setText(food_name[i]);
          txt_price.setText(String.valueOf(food_price[i])); // Convert int to String
          txt_quantity.setText(String.valueOf(quantityNum[i])); // Convert int to String





        return view;
    }
}
