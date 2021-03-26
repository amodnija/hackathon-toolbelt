package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Converter extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        b1 = (Button)findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLength();
            }
        });

        b2 = (Button)findViewById(R.id.b2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeight();
            }
        });

        b3 = (Button)findViewById(R.id.b3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTemperature();
            }
        });

    }
    public void openLength() {
        Intent intent = new Intent(this, Length.class);
        startActivity(intent);
    }

    public void openWeight() {
        Intent intent = new Intent(this, Weight.class);
        startActivity(intent);
    }

    public void openTemperature() {
        Intent intent = new Intent(this, Temperature.class);
        startActivity(intent);
    }
}