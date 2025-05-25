package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class VarietyFoodMenu extends AppCompatActivity {

    String friedRiceNames[]={"Veg Fried Rice ","Chicken Fried Rice ","Egg Fried Rice","Schezwan Fried Rice"};
    String briyaniNames[]={"Veg Biryani","Chicken Biryani","Mutton Biryani","Fish Biryani"};
    int prices[]={190,240,250,250},imageValue;
    String food_name;
    int briyaniImages[]={R.drawable.vegbiryani,R.drawable.chickenbriyani,R.drawable.muttonbiryani,R.drawable.fishbiryani};
    int friedRiceImages[]={R.drawable.vegfriedrice,R.drawable.chickenfriedrice,R.drawable.eggfriedrice,R.drawable.schezwanfriedrice};

    String[] burgerNames={"Veg Burger", "Chicken Burger"},pizzaNames={"Veg Pizza", "Chicken Pizza"},sandwichNames={"Veg Sandwich", "Chicken Sandwich"},shawarmaNames={"Veg Shawarma", "Chicken Shawarma"},tacosNames={"Veg Tacos", "Chicken Tacos"};
    int burgerImages[]={R.drawable.burger,R.drawable.chickenburger};
    int burgerPrices[]={140,180};
    int pizzaImages[]={R.drawable.pizza,R.drawable.chickenpizza};
    int shawarmaImages[]={R.drawable.shawarma,R.drawable.chickenshawarma};
    int shawarmaPrices[]={110,130};
    int sandwichImages[]={R.drawable.sandwich,R.drawable.chickensandwich};
    int sandwichPrices[]={100,145};
    int tacosImages[]={R.drawable.tacos,R.drawable.chickentacos};
    int tacosPrices[]={90,135};
    ListView varietyList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variety_food_menu);
        varietyList=findViewById(R.id.varietyFoodList);

        Bundle bundle=getIntent().getExtras();
        imageValue=bundle.getInt("image");
        food_name=bundle.getString("name");

        if (food_name.equals("Biryani")) {
            CustomListAdapter customListAdapter = new CustomListAdapter(briyaniNames, prices, briyaniImages, VarietyFoodMenu.this);
            varietyList.setAdapter(customListAdapter);
        }
        else if (food_name.equals("Fried Rice")) {
            CustomListAdapter customListAdapter = new CustomListAdapter(friedRiceNames, prices, friedRiceImages, VarietyFoodMenu.this);
            varietyList.setAdapter(customListAdapter);
        }
        else if (food_name.equals("Burger")) {
            CustomListAdapter customListAdapter = new CustomListAdapter(burgerNames, burgerPrices,burgerImages, VarietyFoodMenu.this);
            varietyList.setAdapter(customListAdapter);
        }
        else if (food_name.equals("Pizza")) {
            CustomListAdapter customListAdapter = new CustomListAdapter(pizzaNames, burgerPrices,pizzaImages, VarietyFoodMenu.this);
            varietyList.setAdapter(customListAdapter);
        }
        else if (food_name.equals("Sandwich")) {
            CustomListAdapter customListAdapter = new CustomListAdapter(sandwichNames, sandwichPrices,sandwichImages, VarietyFoodMenu.this);
            varietyList.setAdapter(customListAdapter);
        }
        else if (food_name.equals("Shawarma")) {
            CustomListAdapter customListAdapter = new CustomListAdapter(shawarmaNames,shawarmaPrices,shawarmaImages, VarietyFoodMenu.this);
            varietyList.setAdapter(customListAdapter);
        }
        else if (food_name.equals("Tacos")) {
            CustomListAdapter customListAdapter = new CustomListAdapter(tacosNames, tacosPrices,tacosImages, VarietyFoodMenu.this);
            varietyList.setAdapter(customListAdapter);
        }

        varietyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(VarietyFoodMenu.this, QuantityActivity.class);
                if(food_name.equals("Fried Rice")){
                    intent.putExtra("name", friedRiceNames[i]);
                    intent.putExtra("image", friedRiceImages[i]);
                    intent.putExtra("price",prices[i]);
                    startActivity(intent);
                } else if (food_name.equals("Biryani")) {
                    intent.putExtra("name", briyaniNames[i]);
                    intent.putExtra("image", briyaniImages[i]);
                    intent.putExtra("price",prices[i]);
                    startActivity(intent);

                }
                else if (food_name.equals("Burger")) {
                    intent.putExtra("name", burgerNames[i]);
                    intent.putExtra("image", burgerImages[i]);
                    intent.putExtra("price",burgerPrices[i]);
                    startActivity(intent);

                }
                else if (food_name.equals("Pizza")) {
                    intent.putExtra("name", pizzaNames[i]);
                    intent.putExtra("image", pizzaImages[i]);
                    intent.putExtra("price",burgerPrices[i]);
                    startActivity(intent);

                }
                else if (food_name.equals("Sandwich")) {
                    intent.putExtra("name", sandwichNames[i]);
                    intent.putExtra("image", sandwichImages[i]);
                    intent.putExtra("price",sandwichPrices[i]);
                    startActivity(intent);
                }
                else if (food_name.equals("Shawarma")) {
                    intent.putExtra("name", shawarmaNames[i]);
                    intent.putExtra("image", shawarmaImages[i]);
                    intent.putExtra("price",shawarmaPrices[i]);
                    startActivity(intent);

                }
                else if (food_name.equals("Tacos")) {
                    intent.putExtra("name", tacosNames[i]);
                    intent.putExtra("image", tacosImages[i]);
                    intent.putExtra("price",tacosPrices[i]);
                    startActivity(intent);

                }

            }
        });



    }
}