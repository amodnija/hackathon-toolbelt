package com.amod.hackathon_toolbelt;

import androidx.appcompat.app.AppCompatActivity;
import com.fathzer.soft.javaluator.DoubleEvaluator;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub, buttonDivision, buttonMul, button10, buttonln, buttone, buttonexp, buttonpi, buttonC, buttonEqual, buttonbsp, buttoncos, buttonsin, buttontan, buttonbrop, buttonbrcl;
    EditText mEditText;

    float mValueOne, mValueTwo;

    boolean mAddition, mSubtract, mMultiplication, mDivision;

    public String rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonln = (Button) findViewById(R.id.buttonln);
        buttone = (Button) findViewById(R.id.buttone);
        buttonexp = (Button) findViewById(R.id.buttonexp);
        buttonpi = (Button) findViewById(R.id.buttonpi);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonsin = (Button) findViewById(R.id.buttonsin);
        buttoncos = (Button) findViewById(R.id.buttoncos);
        buttontan = (Button) findViewById(R.id.buttontan);
        buttonbsp = (Button) findViewById(R.id.buttonbsp);
        buttonbrop = (Button) findViewById(R.id.buttonbrop);
        buttonbrcl = (Button) findViewById(R.id.buttonbrcl);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        mEditText = (EditText) findViewById(R.id.edt1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "+");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "-");
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "*");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "/");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                rep = mEditText.getText().toString();
                DoubleEvaluator eval = new DoubleEvaluator();
                try {
                    Double result = eval.evaluate(rep);
                    mEditText.setText(result + "");
                }
                catch (Exception e) {
                    mEditText.setText("error");
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + ".");
            }
        });

        buttonpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "3.141");
            }
        });

        buttone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "2.718");
            }
        });

        buttonexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "^");
            }
        });

        buttonln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "ln(");
            }
        });

        buttonsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "sin(");
            }
        });

        buttoncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "cos(");
            }
        });

        buttontan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "tan(");
            }
        });

        buttonbrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + "(");
            }
        });

        buttonbrcl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                mEditText.setText(mEditText.getText() + ")");
            }
        });

        buttonbsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("error")) {
                    mEditText.setText("");
                }
                String textInBox = mEditText.getText().toString();
                if(textInBox.length() > 0)
                {
                    String newText = textInBox.substring(0, textInBox.length()-1);
                    mEditText.setText(newText);
                }
            }
        });
    }
}

