package com.example.calculatorapp;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    TextView inputTxt,inputOutPut;
    ImageView zero,one,two,three,four,five,six,seven,eigth,nine;
    ImageView add,delete,equal,minus,multiplicaton,percentage,point;
    String data;

    public void hideBottomNavigationBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
            WindowInsetsController controller = getWindow().getInsetsController();
            if(controller != null) {
                controller.hide(WindowInsets.Type.navigationBars());
                controller.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideBottomNavigationBar();

        getSupportActionBar().hide();



        inputTxt = findViewById(R.id.inputTxt);
        inputOutPut = findViewById(R.id.inputOutPut);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eigth = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        equal = findViewById(R.id.equal);
        minus = findViewById(R.id.minus);
        multiplicaton = findViewById(R.id.multiplication);
        percentage = findViewById(R.id.percentage);
        point = findViewById(R.id.point);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "1");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "7");
            }
        });

        eigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "9");
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + ".");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.setText("");
                inputOutPut.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "+");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "-");
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "%");
            }
        });

        multiplicaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "x");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                data = data.replaceAll("x", "*");
                data = data.replaceAll("%", "/100");
                data = data.replaceAll("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";

                Scriptable scriptable = rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable, data, "JavaScript", 1, null).toString();

                inputOutPut.setText(finalResult);


            }
        });
    }
}