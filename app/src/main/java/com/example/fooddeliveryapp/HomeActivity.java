package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {
    ListView listView;
    String names[]={"Starter","Break Fast","Rice","Fast Food"};
    int price[]={0,0,0,0};
    int images[]={R.drawable.starters,R.drawable.indianbreakfast,R.drawable.chickenbriyani,R.drawable.burger};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView=findViewById(R.id.list_view);

        CustomListAdapter customListAdapter=new CustomListAdapter(names,price,images,HomeActivity.this);
        listView.setAdapter(customListAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences preferences=getSharedPreferences("food",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();

                if(names[i].equals("Starter")){
                    editor.putString("foodname",names[i]);
                    editor.commit();
                }
                else if(names[i].equals("Break Fast")){
                    editor.putString("foodname",names[i]);
                    editor.commit();

                }
                else if(names[i].equals("Rice")){
                    editor.putString("foodname",names[i]);
                    editor.commit();



                }
                else if(names[i].equals("Fast Food")){
                    editor.putString("foodname",names[i]);
                    editor.commit();

                }
                Intent in = new Intent(HomeActivity.this, FoodMenuActivity.class);
                startActivity(in);

            }
        });

    }
}