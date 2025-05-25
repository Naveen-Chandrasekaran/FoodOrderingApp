package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class FoodMenuActivity extends AppCompatActivity {

    String names[]={"Starter","Break Fast","Rice","Fast Food"};
    int[] startersImages ={R.drawable.frenchfries,R.drawable.paneermanchurian,R.drawable.panipuri,R.drawable.samosa,R.drawable.vegcutlet};
    String startersName[]={"French Fries","Paneer Manchurian","Pani Puri","Samosa","Veg Cutlet"};
    int breakfastImages[]={R.drawable.idly,R.drawable.dosa,R.drawable.chappathi,R.drawable.poori,R.drawable.parotta};
    String breakfastNames[]={"Idly","Dosa","Chappathi","Poori","Parotta"};
    int riceImages[]={R.drawable.tamarindrice,R.drawable.coconutrice,R.drawable.curdrice,R.drawable.sambar,R.drawable.lemonrice,R.drawable.vegfriedrice,R.drawable.chickenbriyani};
    String riceNames[]={"Tamarind Rice","Coconut Rice","Curd Rice","Sambar","Lemon Rice","Fried Rice","Biryani"};
    int fastfoodImages[]={R.drawable.burger,R.drawable.pizza,R.drawable.sandwich,R.drawable.shawarma,R.drawable.tacos};
    String fastfoodNames[]={"Burger","Pizza","Sandwich","Shawarma","Tacos"};

    int starterPrices[]={80,140,75,65,50};
    int breakfastPrices[]={60,65,65,65,60};
    int []ricePrices={75,90,100,75,70,190,190};
    int []fastFoodPrices={140,140,100,110,90};

    String burgerNames[]={"Veg ", "Chicken "};
    int burgerImages[]={R.drawable.burger,R.drawable.burger};
    int burgerPrices[]={140,180};
    int pizzaImages[]={R.drawable.pizza,R.drawable.pizza};
    int shawarmaImages[]={R.drawable.shawarma,R.drawable.shawarma};
    int shawarmaPrices[]={110,130};
    int sandwichImages[]={R.drawable.sandwich,R.drawable.sandwich};
    int sandwichPrices[]={100,145};
    int tacosImages[]={R.drawable.tacos,R.drawable.tacos};
    int tacosPrices[]={90,135};

    ListView listFoodMenu;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        listFoodMenu=findViewById(R.id.list_view_menu);

        SharedPreferences preferences=getSharedPreferences("food",MODE_PRIVATE);
        String foodName=preferences.getString("foodname","");


        switch (foodName) {
            case "Starter": {
                CustomListAdapter customListAdapter = new CustomListAdapter(startersName, starterPrices,startersImages, FoodMenuActivity.this);
                listFoodMenu.setAdapter(customListAdapter);

                break;
            }
            case "Break Fast": {
                CustomListAdapter customListAdapter = new CustomListAdapter(breakfastNames,breakfastPrices, breakfastImages, FoodMenuActivity.this);
                listFoodMenu.setAdapter(customListAdapter);
                break;
            }
            case "Rice": {
                CustomListAdapter customListAdapter = new CustomListAdapter(riceNames,ricePrices, riceImages, FoodMenuActivity.this);
                listFoodMenu.setAdapter(customListAdapter);
                break;
            }
            case "Fast Food": {
                CustomListAdapter customListAdapter = new CustomListAdapter(fastfoodNames, fastFoodPrices,fastfoodImages, FoodMenuActivity.this);
                listFoodMenu.setAdapter(customListAdapter);
                break;
            }
        }


        listFoodMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent in =new Intent(FoodMenuActivity.this, QuantityActivity.class);

                if(foodName.equals(names[0])) {
                    in.putExtra("name", startersName[i]);
                    in.putExtra("image", startersImages[i]);
                    in.putExtra("price",starterPrices[i]);
                    startActivity(in);
                }
                else if(foodName.equals(names[1])) {
                    in.putExtra("name", breakfastNames[i]);
                    in.putExtra("image", breakfastImages[i]);
                    in.putExtra("price",breakfastPrices[i]);
                    startActivity(in);
                }
                else if(foodName.equals(names[2])) {
                    if(riceNames[i].equals("Fried Rice")){
                        Intent intent= new Intent(FoodMenuActivity.this, VarietyFoodMenu.class);
                        intent.putExtra("name",riceNames[i]);
                        intent.putExtra("image", riceImages[i]);
                        startActivity(intent);
                    }
                    else if(riceNames[i].equals("Biryani")){
                        Intent intent= new Intent(FoodMenuActivity.this, VarietyFoodMenu.class);
                        intent.putExtra("name",riceNames[i]);
                        intent.putExtra("image", riceImages[i]);
                        startActivity(intent);
                    }
                    else {
                        in.putExtra("name", riceNames[i]);
                        in.putExtra("image", riceImages[i]);
                        in.putExtra("price",ricePrices[i]);
                        startActivity(in);
                    }
                }
                else if(foodName.equals(names[3])) {

                    if(fastfoodNames[i].equals("Burger")){
                        Intent intent= new Intent(FoodMenuActivity.this, VarietyFoodMenu.class);
                        intent.putExtra("name",fastfoodNames[i]);
                        intent.putExtra("image", fastfoodImages[i]);
                        startActivity(intent);
                    }
                    else if(fastfoodNames[i].equals("Pizza")){
                        Intent intent= new Intent(FoodMenuActivity.this, VarietyFoodMenu.class);
                        intent.putExtra("name",fastfoodNames[i]);
                        intent.putExtra("image", fastfoodImages[i]);
                        startActivity(intent);
                    }
                    else if(fastfoodNames[i].equals("Sandwich")){
                        Intent intent= new Intent(FoodMenuActivity.this, VarietyFoodMenu.class);
                        intent.putExtra("name",fastfoodNames[i]);
                        intent.putExtra("image", fastfoodImages[i]);
                        startActivity(intent);
                    }
                    else if(fastfoodNames[i].equals("Shawarma")){
                        Intent intent= new Intent(FoodMenuActivity.this, VarietyFoodMenu.class);
                        intent.putExtra("name",fastfoodNames[i]);
                        intent.putExtra("image", fastfoodImages[i]);
                        startActivity(intent);
                    }
                    else if(fastfoodNames[i].equals("Tacos")){
                        Intent intent= new Intent(FoodMenuActivity.this, VarietyFoodMenu.class);
                        intent.putExtra("name",fastfoodNames[i]);
                        intent.putExtra("image", fastfoodImages[i]);
                        startActivity(intent);
                    }
                }




            }
        });



    }
}