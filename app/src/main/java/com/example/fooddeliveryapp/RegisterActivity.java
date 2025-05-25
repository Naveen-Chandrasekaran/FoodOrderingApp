package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText name,pass,email,number;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.userName);
        pass=findViewById(R.id.pass);
        email=findViewById(R.id.email);
        number=findViewById(R.id.num);
        register=findViewById(R.id.BtnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String pass1=pass.getText().toString();
                String email1=email.getText().toString();
                String number1=number.getText().toString();

                if(name1.equals("") | pass1.equals("") | email1.equals("") | number1.equals("")  ){
                    Toast.makeText(RegisterActivity.this,"PLEASE FILL ALL THE DETAILS",Toast.LENGTH_SHORT).show();

                } else if (number1.length() != 10) {
                    number.setError("Please Enter 10 Digit Mobile Number");
                }
                else{
                    SharedPreferences preferences=getSharedPreferences("user",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();

                    editor.putString("name",name1);
                    editor.putString("pass",pass1);
                    editor.putString("email",email1);
                    editor.putString("number",number1);

                    editor.commit();

                    Toast.makeText(RegisterActivity.this,"Hi "+name1+" Registered Successfully!!",Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(in);
                }

            }

        });
    }
}