package com.example.rakshitayadav.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,minus,into,divide,equal,clr;
    TextView text, result;
    private final char ADD = '+';
    private final char SUBTRACT = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private char EQU=0;
    private double val1 = Double.NaN;
    private double val2;
    private static int FLAG=0;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                text.setText(text.getText().toString() + "9");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(FLAG==0)
                    Toast.makeText(MainActivity.this,"Enter numbers.",Toast.LENGTH_LONG).show();
                else
                {
                    compute();
                    ACTION=ADD;
                    result.setText(String.valueOf(val1)+ "+");
                    text.setText(null);
                    FLAG=1;
                }

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(FLAG==0)
                    Toast.makeText(MainActivity.this,"Enter numbers.",Toast.LENGTH_LONG).show();
                else
                {
                    compute();
                    ACTION=SUBTRACT;
                    result.setText(String.valueOf(val1)+ "-");
                    text.setText(null);
                    FLAG=1;
                }
            }
        });

        into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(FLAG==0)
                    Toast.makeText(MainActivity.this,"Enter numbers.",Toast.LENGTH_LONG).show();
                else
                {
                    compute();
                    ACTION=MULTIPLY;
                    result.setText(String.valueOf(val1)+ "*");
                    text.setText(null);
                    FLAG=1;
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(FLAG==0)
                    Toast.makeText(MainActivity.this,"Enter numbers.",Toast.LENGTH_LONG).show();
                else
                {
                    compute();
                    ACTION=DIVIDE;
                    result.setText(String.valueOf(val1)+ "/");
                    text.setText(null);
                    FLAG=1;
                }

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FLAG==0)
                    Toast.makeText(MainActivity.this,"Enter numbers.",Toast.LENGTH_LONG).show();
                else
                {
                    compute();
                    ACTION=EQU;
                    result.setText(String.valueOf(val1));
                    text.setText(null);
                    FLAG=1;
                }
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().length()>0)
                {
                    CharSequence name = text.getText().toString();
                    text.setText((name.subSequence(0,name.length()-1)));
                }
                else
                {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    text.setText(null);
                    result.setText(null);
                }
            }
        });

    }

    private void setUI()
    {
        b1=findViewById(R.id.one);
        b2=findViewById(R.id.two);
        b3=findViewById(R.id.three);
        b4=findViewById(R.id.four);
        b5=findViewById(R.id.five);
        b6=findViewById(R.id.six);
        b7=findViewById(R.id.seven);
        b8=findViewById(R.id.eight);
        b9=findViewById(R.id.nine);
        b0=findViewById(R.id.zero);

        equal=findViewById(R.id.equal);

        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        into=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);

        clr=findViewById(R.id.clear);

        text=findViewById(R.id.type_text);
        result=findViewById(R.id.result);
    }

    private void compute()
    {
        if(!Double.isNaN(val1))
        {
            val2= Double.parseDouble(text.getText().toString());

            switch (ACTION)
            {
                case ADD:
                    val1=val1+val2;
                    break;
                case SUBTRACT:
                    val1=val1-val2;
                    break;
                case MULTIPLY:
                    val1=val1*val2;
                    break;
                case DIVIDE:
                    val1=val1/val2;
                    break;
                default:
                    break;
            }
        }
        else
        {
            val1 = Double.parseDouble(text.getText().toString());
        }
    }
}
