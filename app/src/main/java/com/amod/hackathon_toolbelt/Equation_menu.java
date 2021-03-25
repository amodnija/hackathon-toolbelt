package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Equation_menu extends AppCompatActivity {

    Button button1, button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_menu);
        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quad();
            }

        });

    }
    public void quad()
    {
        Intent intent = new Intent(this, Quadratic.class);
        startActivity(intent);
    }
    public void linear()
    {
        Intent intent = new Intent(this, Linear_equation.class);
        startActivity(intent);
    }
}