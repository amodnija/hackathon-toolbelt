package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class Startup extends AppCompatActivity {

    private Button stopwatch, converter, mainactivity, equationmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main1);
        stopwatch = (Button) findViewById(R.id.button);
        mainactivity = (Button) findViewById(R.id.button1);
        converter = (Button) findViewById(R.id.button2);
        equationmenu = (Button) findViewById(R.id.button3);

        stopwatch.setOnClickListener(view -> {
            Intent intent = new Intent(this, Stopwatch.class);
            startActivity(intent);
        });

        /*mainactivity.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        converter.setOnClickListener(view -> {
            Intent intent = new Intent(this, Converter.class);
            startActivity(intent);
        });

        equationmenu.setOnClickListener(view -> {
            Intent intent = new Intent(this, Equation_menu.class);
            startActivity(intent);
        });**/

    }
}
