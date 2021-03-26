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
import java.io.*;

public class Linear_equation extends AppCompatActivity {

    EditText et;
    TextView tv;
    Button b, bc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_equation);

        et = findViewById(R.id.et4);
        b = findViewById(R.id.b4);
        tv = findViewById(R.id.textView4);
        bc = findViewById(R.id.b6);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eqn = et.getText().toString();
                String ANS="";
                tv.setText("");
                boolean check = true;

                if (eqn.matches("")) {
                    if(TextUtils.isEmpty(eqn)) {
                        et.setError("Equation cannot be empty");
                        return;
                    }
                    check=false;
                }

                try{

                if(check) {

                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                    int n = eqn.length(),
                                    sign = 1, coeff = 0;
                            int total = 0, i = 0;

                            // Traverse the equation
                            for (int j = 0; j < n; j++)
                            {
                                if (eqn.charAt(j) == '+' ||
                                        eqn.charAt(j) == '-')
                                {
                                    if (j > i)
                                        total += sign * Integer.parseInt(eqn.substring(i, j));
                                    i = j;
                                }

                                // For cases such
                                // as: x, -x, +x
                                else if (eqn.charAt(j) == 'x')
                                {
                                    if ((i == j) ||
                                            eqn.charAt(j - 1) == '+')
                                        coeff += sign;

                                    else if (eqn.charAt(j - 1) == '-')
                                        coeff -= sign;

                                    else
                                        coeff += sign * Integer.parseInt(eqn.substring(i, j));
                                    i = j + 1;
                                }

                                // Flip sign once
                                // '=' is seen
                                else if (eqn.charAt(j) == '=')
                                {
                                    if (j > i)
                                        total += sign * Integer.parseInt(eqn.substring(i, j));
                                    sign = -1;
                                    i = j + 1;
                                }
                            }

                            // There may be a
                            // number left in the end
                            if (i < n)
                                total = total + (sign * Integer.parseInt(eqn.substring(i)));

                            // For infinite
                            // solutions
                            if (coeff == 0 &&
                                    total == 0)
                                ANS = "Infinite solutions";

                            // For no solution
                            if (coeff == 0 &&
                                    total != 0)
                                ANS = "No solution";



                            float ans = -(float)total / (float)coeff;
                            ANS = (Float.toString(ans));
                        }

                        // Driver code




                    tv.setText(ANS);


                }catch(Exception e){
                    Toast.makeText(Linear_equation.this, "Make sure your equation does not contain any unnecessary characters or spaces", Toast.LENGTH_LONG).show();

                }
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
                tv.setText("");
                tv.setHint("Value of x");
            }
        });




    }
}