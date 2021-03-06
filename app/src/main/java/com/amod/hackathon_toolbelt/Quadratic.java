package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Quadratic extends AppCompatActivity {
    EditText a, b, c;
    Button button, bclear;
    TextView t2, t4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);
        a = findViewById(R.id.et1);
        b = findViewById(R.id.et2);
        c = findViewById(R.id.et3);
        t2 = findViewById(R.id.tv2);
        t4 = findViewById(R.id.tv5);

        bclear = findViewById(R.id.b5);

        button = findViewById(R.id.b3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;


                if (a.getText().toString().matches("") || TextUtils.isEmpty(a.getText().toString()) || Double.parseDouble(a.getText().toString()) == 0.0) {

                    Toast.makeText(Quadratic.this, "Value of \"a\" cannot be empty or zero", Toast.LENGTH_LONG).show();
                    check = false;

                }

                if (b.getText().toString().matches("")) {

                    b.setText("0");
                }
                if (c.getText().toString().matches("")) {
                    c.setText("0");
                }

                if(check) {

                    if (b.getText().toString().matches("")) {

                        b.setText("0");
                    }
                    if (c.getText().toString().matches("")) {
                        c.setText("0");
                    }
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                    final double A = Double.parseDouble(a.getText().toString());
                    final double B = Double.parseDouble(b.getText().toString());
                    final double C = Double.parseDouble(c.getText().toString());
                    final double x1 = (-(B) + Math.sqrt(Math.pow(B, 2.0) - 4 * A * C)) / (2 * A);
                    final double x2 = (-(B) - Math.sqrt(Math.pow(B, 2.0) - 4 * A * C)) / (2 * A);

                    t2.setText(String.format("%.4f", x1).toString());
                    t4.setText(String.format("%.4f", x2).toString());
                }




            }
        });

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setText("");
                b.setText("");
                c.setText("");
                t2.setText("");
                t4.setText("");

            }
        });


    }
}