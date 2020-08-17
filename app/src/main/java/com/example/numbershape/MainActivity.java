package com.example.numbershape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isSquare;
    boolean isTriangle;

    class Number {
        int number;

        public Number(int number) {
            this.number = number;
        }
        public boolean isTriangle() {
            int counter = 1;
            int triangular = 0;

            while (true) {
                if (number < triangular) {
                    return false;
                }
                if (number == triangular) {
                    return true;
                }
                triangular += counter++;

            }
        }

        public boolean isSquare() {
            int counter = 1;
            int square = 0;

            while (true) {
                if (number < square) {
                    return false;
                }
                if (number == square) {
                    return true;
                }
                square += counter;
                counter += 2;
            }
        }
    }
    public void check(View view) {
        EditText input = (EditText) findViewById(R.id.numberEditText);
        if (input.getText().toString().isEmpty()) {
            Toast.makeText(this, "Type a number", Toast.LENGTH_SHORT).show();
            return;
        }
        int intInput = Integer.parseInt(input.getText().toString());

        Number number = new Number(intInput);
        String message = "The number is neighther triangular nor square";
        if (number.isTriangle() && number.isSquare()) {
            message = "The number is both square and triangle";
        } else if (number.isTriangle()) {
            message = "The number is triangular";
        } else if (number.isSquare()) {
            message = "The number is square";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}