package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class PaymentActivity extends AppCompatActivity {

    ListView java_payment_list ;
    TextView total_price;
    EditText pay_price;
    Button pay;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        java_payment_list= findViewById(R.id.payment_list);
        total_price=findViewById(R.id.total_price);
        pay_price=findViewById(R.id.pay_price);
        pay=findViewById(R.id.pay);





            SharedPreferences sharedPreferences = getSharedPreferences("cart", MODE_PRIVATE);
            int productCount = sharedPreferences.getInt("productCount", 0);


           String [] product_names = new String[productCount + 1];
           int[] product_price = new int[productCount + 1];
           int[] product_quantity = new int[productCount + 1];

            for (int i = 0; i <=productCount; i++) {
                product_names[i] = sharedPreferences.getString("food_name_"+i, "");
                product_price[i] = sharedPreferences.getInt("food_price_"+i, 0);
                product_quantity[i] = sharedPreferences.getInt("food_quantity_"+i, 0);

            }

        // Removing the null Values
        int size2=product_names.length-1;
        String [] product_names2 = new String[size2];
        int[] product_price2 = new int[size2];
        int[] product_quantity2 = new int[size2];

        for(int j=1;j<product_names.length;j++){
            product_names2[j-1]=product_names[j];
            product_price2[j-1]=product_price[j];
            product_quantity2[j-1]=product_quantity[j];
        }


            PaymentListAdapter paymentListAdapter = new PaymentListAdapter(product_names2, product_price2, product_quantity2, PaymentActivity.this);
            java_payment_list.setAdapter(paymentListAdapter);

            int totalprice=0;
            for(int j=0;j<=productCount;j++){
                totalprice=totalprice+product_price[j];
            }
            total_price.setText(""+totalprice);

        int finalTotalprice = totalprice;
        pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String payPrice=pay_price.getText().toString();
                    if(payPrice.equals(""+ finalTotalprice)){
                        Toast.makeText(PaymentActivity.this, "Congratulations!! , Your Order is Placed", Toast.LENGTH_SHORT).show();
                        SharedPreferences preferences=getSharedPreferences("user",MODE_PRIVATE);
                        String phoneNo=preferences.getString("number","");
                        String userName=preferences.getString("name","");

                        SmsManager smsManager=SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNo,null,"Hi "+userName +"!, Your Order is Placed!!.This message is confirmation of your order. Your Order will be delivered shortly.",null,null);

                        // Clear cart items
                        SharedPreferences sharedPreferences = getSharedPreferences("cart", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.apply();


                    }
                    else{
                        Toast.makeText(PaymentActivity.this, "Please Enter Total Price Amount to Place Your Order  ", Toast.LENGTH_SHORT).show();

                    }

                }
            });


















    }
}