package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Simultaneous_eq extends AppCompatActivity {

    EditText eq1, eq2;
    TextView X, Y;
    Button bsim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simultaneous_eq);

        eq1 = findViewById(R.id.et5);
        eq2 = findViewById(R.id.et6);
        X = findViewById(R.id.tv6);
        Y = findViewById(R.id.tv7);
        bsim = findViewById(R.id.b8);

        bsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Eq1 = eq1.getText().toString();
                String Eq2 = eq2.getText().toString();

        double a1=0,b1=0,c1=0,a2=0,b2=0,c2=0,x=0,y=0;
            try{
                if(Eq1.charAt(0) == '-')
                {
                    try {
                        a1 = Double.parseDouble(Eq1.substring(1, Eq1.indexOf('x')));
                    }catch (Exception e){
                        a1=-1.0;
                    }
                }
            if (Eq1.charAt(0) == 'x')
                a1 = 1.0;
            else
                a1 = Double.parseDouble(Eq1.substring(0, Eq1.indexOf('x')));
            try {
                if (Eq1.indexOf('+') != -1)
                    b1 = Double.parseDouble(Eq1.substring((Eq1.indexOf('x') + 2), Eq1.indexOf('y')));
            } catch (Exception e) {
                b2 = 1.0;
            }
            try{
                if (Eq1.indexOf('-') != -1 && Eq1.indexOf('-') < Eq1.indexOf('='))
                    b1 = -(Double.parseDouble(Eq1.substring((Eq1.indexOf('x') + 2), Eq1.indexOf('y'))));
            } catch (Exception e) {
                b1 =-1.0;

            }


            if (Eq1.charAt((Eq1.indexOf('=') + 1)) == '-')
                c1 = -(Double.parseDouble(Eq1.substring((Eq1.indexOf('=') + 1))));
            else
                c1 = Double.parseDouble(Eq1.substring((Eq1.indexOf('=') + 1)));

                if(Eq2.charAt(0) == '-')
                {
                    try {
                        a2 = Double.parseDouble(Eq1.substring(1, Eq2.indexOf('x')));
                    }catch (Exception e){
                        a2=-1.0;
                    }
                }

            if (Eq2.charAt(0) == 'x')
                a2 = 1.0;
            else

                a2 = Double.parseDouble(Eq2.substring(0, Eq2.indexOf('x')));

            try {
                if (Eq1.indexOf('+') != -1)
                    b2 = Double.parseDouble(Eq2.substring((Eq2.indexOf('x') + 2), Eq2.indexOf('y')));
            } catch (Exception e) {
                b2 = 1.0;
            }
            try {
                if (Eq2.indexOf('-') != -1 && Eq2.indexOf('-') < Eq2.indexOf('='))
                    b2 = -(Double.parseDouble(Eq2.substring((Eq2.indexOf('x') + 2), Eq2.indexOf('y'))));
            }catch(Exception e){
                b2=-1.0;
            }


            if (Eq2.charAt((Eq2.indexOf('=') + 1)) == '-')
                c2 = -(Double.parseDouble(Eq2.substring((Eq2.indexOf('=') + 1))));
            else
                c2 = Double.parseDouble(Eq2.substring((Eq2.indexOf('=') + 1)));


            x = ((c1 * b2) - (c2 * b1)) / ((a1 * b2) - (a2 * b1));
            y = ((a1 * c2) - (a2 * c1)) / ((a1 * b2) - (a2 * b1));

            X.setText(String.format("%.2f", x).toString());
            Y.setText(String.format("%.2f", x).toString());
            }catch(Exception e){
            Toast.makeText(Simultaneous_eq.this, "Recheck your Equations", Toast.LENGTH_LONG).show();
        }

            }
        });


    }
}