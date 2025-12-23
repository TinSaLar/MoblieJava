package com.example.hoccungmoblie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtDisplay;
    double first = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = findViewById(R.id.txtDisplay);

        int[] ids = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnDot,
                R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv,
                R.id.btnEqual, R.id.btnClear
        };

        for (int id : ids) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String text = b.getText().toString();

        switch (text) {
            case "AC":
                txtDisplay.setText("0");
                first = 0;
                operator = "";
                break;

            case "+":
            case "-":
            case "×":
            case "÷":
                first = Double.parseDouble(txtDisplay.getText().toString());
                operator = text;
                txtDisplay.setText("0");
                break;

            case "=":
                double second = Double.parseDouble(txtDisplay.getText().toString());
                double result = 0;

                switch (operator) {
                    case "+": result = first + second; break;
                    case "-": result = first - second; break;
                    case "×": result = first * second; break;
                    case "÷": result = second == 0 ? 0 : first / second; break;
                }

                txtDisplay.setText(String.valueOf(result));
                break;

            default:
                if (txtDisplay.getText().toString().equals("0"))
                    txtDisplay.setText(text);
                else
                    txtDisplay.append(text);
        }
    }
}
