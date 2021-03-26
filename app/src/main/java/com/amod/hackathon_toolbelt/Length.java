package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Length extends AppCompatActivity {
    Spinner sp1,sp2;
    EditText et1;
    TextView et2;
    Button button3;
    Double tot = new Double(0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        sp1 = findViewById(R.id.spinner1);
        sp2 = findViewById(R.id.spinner2);
        button3 = findViewById(R.id.button3);

        String[] from = {"Kilometres","Miles"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to = {"Kilometres","Miles"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double amount = Double.parseDouble(et1.getText().toString());
                if(sp1.getSelectedItem().toString() == "Kilometres" && sp2.getSelectedItem().toString() == "Kilometres" )
                {
                    tot = amount;
                    Log.i("TAG", "onClick: "+ tot);
                    et2.setText(tot.toString());
                }

                if(sp1.getSelectedItem().toString() == "Kilometres" && sp2.getSelectedItem().toString() == "Miles" )
                {
                    tot = amount * 0.621;
                    Log.i("TAG", "onClick: "+ tot);
                    et2.setText(tot.toString());
                }

                if(sp1.getSelectedItem().toString() == "Miles" && sp2.getSelectedItem().toString() == "Kilometres" )
                {
                    tot = amount * 1.609;
                    et2.setText(tot.toString());
                }

                if(sp1.getSelectedItem().toString() == "Miles" && sp2.getSelectedItem().toString() == "Miles" )
                {
                    tot = amount;
                    et2.setText(tot.toString());
                }
            }
        });
    }
}