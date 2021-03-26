package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                tv.setText("");
                boolean check = true;

                if (eqn.matches("")) {
                    if(TextUtils.isEmpty(eqn)) {
                        et.setError("Equation cannot be empty");
                        return;
                    }
                    check=false;
                }
                /*if(eqn.matches("^(?![xX0-9+=-])"[A-Za-z!#$%&{|}~:;<>?@*,.^_`\\'\\\" \\t\\r\\n\\f]")||eqn.matches("")) {
                   Toast.makeText(Linear_equation.this, "Make sure your equation does not contain any unnecessary special characters or space", Toast.LENGTH_LONG).show();
                    check = false;

                }*/
                try{

                if(check) {



                    float ans = 0;
                    float coeffSum = 0;
                    float constSum = 0;
                    float[] coeffx = new float[100];
                    float[] constant = new float[100];

                    eqn += "\n";
                    // System.out.println(eqn);
                    for (int i = 0, j = 0, k = 0; i < eqn.length() - 1; ) {
                        if (eqn.charAt(i + 1) == 'x' && i < eqn.indexOf("=")) {
                            if (i != 0 && eqn.charAt(i - 1) == '-') {
                                String x = eqn.substring(i, i + 1);
                                if (x != "+" && x != "-") {
                                    int n = -(Integer.parseInt(x, 10));
                                    coeffx[j++] = n;
                                }
                            } else {
                                String x = eqn.substring(i, i + 1);
                                if (x != "+" && x != "-") {
                                    int n = Integer.parseInt(x, 10);
                                    coeffx[j++] = n;
                                }
                            }
                            i += 3;
                        }
                        if (eqn.charAt(i + 1) == 'x' && i > eqn.indexOf("=")) {
                            if (eqn.charAt(i - 1) == '-') {
                                String x = eqn.substring(i, i + 1);
                                if (x != "+" && x != "-") {
                                    int n = Integer.parseInt(x, 10);
                                    coeffx[j++] = n;
                                }
                            } else {
                                String x = eqn.substring(i, i + 1);
                                if (x != "+" && x != "-") {
                                    int n = -(Integer.parseInt(x, 10));
                                    coeffx[j++] = n;
                                }
                            }
                            i += 3;
                        }
                        if (eqn.charAt(i + 1) != 'x' && i < eqn.indexOf("=")) {
                            if (eqn.charAt(i - 1) == '-') {
                                String x = eqn.substring(i, i + 1);
                                if (x != "+" && x != "-") {
                                    int n = -(Integer.parseInt(x, 10));
                                    constant[k++] = n;
                                }
                            } else {
                                String x = eqn.substring(i, i + 1);
                                if (x != "+" && x != "-") {
                                    int n = Integer.parseInt(x, 10);
                                    constant[k++] = n;
                                }
                            }
                            i += 2;
                        }
                        if (eqn.charAt(i + 1) != 'x' && i > eqn.indexOf("=")) {
                            if (eqn.charAt(i - 1) == '-') {
                                String x = eqn.substring(i, i + 1);
                                if (x != "+" && x != "-") {
                                    int n = Integer.parseInt(x, 10);
                                    constant[k++] = n;
                                }
                            } else {
                                String x = eqn.substring(i, i + 1);
                                if (x != "+" && x != "-") {
                                    int n = -(Integer.parseInt(x, 10));
                                    constant[k++] = n;
                                }
                            }
                            i += 2;
                        }

                    }
                    for (int i = 0; i < coeffx.length; i++)
                        coeffSum += coeffx[i];
                    for (int i = 0; i < constant.length; i++)
                        constSum += constant[i];
                    ans = constSum / coeffSum;

                    tv.setText(Float.toString((-ans)));


                }}catch (Exception e){
                    Toast.makeText(Linear_equation.this, "Make sure your equation does not contain any unnecessary characters or spaces", Toast.LENGTH_LONG).show();

                }
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
                tv.setText("");
            }
        });




    }
}