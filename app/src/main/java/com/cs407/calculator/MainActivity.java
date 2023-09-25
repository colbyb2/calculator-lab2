package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view) {
        Button clicked = (Button)view;
        String op = clicked.getText().toString();

        EditText firstField = findViewById(R.id.firstNumber);
        EditText secondField = findViewById(R.id.secondNumber);
        int firstNumber;
        int secondNumber;
        try {
            firstNumber = Integer.parseInt(firstField.getText().toString());
            secondNumber = Integer.parseInt(secondField.getText().toString());
        } catch (NumberFormatException e) {
            goToActivity("Did not enter a valid number.");
            return;
        }

        String result = null;
        switch(op) {
            case "+":
                result = Integer.toString(firstNumber + secondNumber);
                break;
            case "-":
                result = Integer.toString(firstNumber - secondNumber);
                break;
            case "*":
                result = Integer.toString(firstNumber * secondNumber);
                break;
            default:
                if (secondNumber == 0) {
                    result = "Cannot divide by zero. Please try again.";
                    break;
                }
                result = Integer.toString(firstNumber / secondNumber);
                break;
        }

        goToActivity(result);
    }

    public void goToActivity(String result) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}