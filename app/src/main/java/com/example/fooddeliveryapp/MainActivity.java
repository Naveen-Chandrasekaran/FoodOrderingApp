package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText loginName,loginPass;
    Button login;
    TextView loginRegister;
    LayoutInflater inflater;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginName=findViewById(R.id.userName);
        loginPass=findViewById(R.id.passWord);
        login=findViewById(R.id.BtnLogin);
        loginRegister=findViewById(R.id.loginRegister);

        //custom toast
        inflater=getLayoutInflater();

        View view=inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_toast_design));
        Toast t=new Toast(MainActivity.this);
        t.setGravity(Gravity.CENTER_VERTICAL,0,0);
        t.setDuration(Toast.LENGTH_SHORT);
        t.setView(view);
        t.show();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=loginName.getText().toString();
                String pass1=loginPass.getText().toString();

                SharedPreferences preferences=getSharedPreferences("user",MODE_PRIVATE);
                String name2=preferences.getString("name","");
                String pass2=preferences.getString("pass","");

                if(name1.equals(name2) ){
                    if(pass1.equals(pass2)){
                        Toast.makeText(MainActivity.this,"Hi "+name1+"! LoggedIn Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);

                    }
                    else{
                        loginPass.setError("Invalid Password");

                    }
                }
                else{
                    loginName.setError("Invalid UserName");


                }
            }
        });

        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });
    }
}