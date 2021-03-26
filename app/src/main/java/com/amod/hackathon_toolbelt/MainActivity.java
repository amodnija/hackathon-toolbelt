package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button b0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = (Button)findViewById(R.id.b0);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConverter();
            }
        });
    }
    public void openConverter() {
        Intent intent = new Intent(this, Converter.class);
        startActivity(intent);
    }
}