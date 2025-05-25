package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class QuantityActivity extends AppCompatActivity {
    ImageView decrement,increment,quantityImage;
    TextView quantityName,quantityNumber,txt_Price;

    int quantityNum=0,imageValue,quantityPrice,food_price;

    String food_name;
    Button btnBack,addToCart,proceedToPayment;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        decrement=findViewById(R.id.decrement);
        increment=findViewById(R.id.increment);
        quantityImage=findViewById(R.id.quantityImage);
        quantityName=findViewById(R.id.quantityName);
        quantityNumber=findViewById(R.id.quantityNumber);
        txt_Price=findViewById(R.id.quantityPrice);
        btnBack=findViewById(R.id.btnBack);
        addToCart=findViewById(R.id.addToCart);
        proceedToPayment=findViewById(R.id.proceedToPayment);

        Bundle bundle=getIntent().getExtras();
        imageValue=bundle.getInt("image");
        food_name=bundle.getString("name");
        quantityPrice=bundle.getInt("price");

        quantityImage.setBackgroundResource(imageValue);
        quantityName.setText(food_name);





        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantityNum>0){
                    quantityNum--;
                    quantityNumber.setText(""+quantityNum);
                    food_price=quantityPrice*quantityNum;
                    txt_Price.setText("Rs. "+food_price);
                }
            }
        });
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantityNum>=0){
                    quantityNum++;
                    quantityNumber.setText(""+quantityNum);
                    food_price=quantityPrice*quantityNum;
                    txt_Price.setText("Rs. "+food_price);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(quantityNum==0){
                    Toast.makeText(QuantityActivity.this,"Please Select an Item",Toast.LENGTH_SHORT).show();
                }
                else{
                    SharedPreferences sharedPreferences=getSharedPreferences("cart",MODE_PRIVATE);
                    int productCount=sharedPreferences.getInt("productCount",0);
                    productCount++;

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putInt("productCount",productCount);
                    editor.commit();

                    editor.putString("food_name_"+productCount,food_name);
                    editor.putInt("food_price_"+productCount,food_price);
                    editor.putInt("food_quantity_"+productCount,quantityNum);
                    editor.commit();


                    Toast.makeText(QuantityActivity.this," "+food_name,Toast.LENGTH_SHORT).show();

                }





            }
        });
        proceedToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantityNum==0){
                    Toast.makeText(QuantityActivity.this,"Please add an item to Cart",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent= new Intent(QuantityActivity.this, PaymentActivity.class);

                    startActivity(intent);
                }


            }
        });




    }
}