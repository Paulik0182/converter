package com.android.urrencyonverter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int RUB_IN_USD = 30;
    private static final int RUB_IN_EUR = 40;
    private static final int RUB_IN_CHF = 10;

    private TextView resultTextView = null;
    private Button usaOpenSecondButton = null;
    private Button eurOpenSecondButton = null;
    private Button chfOpenSecondButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        openResultScreen();
    }

    private void openResultScreen() {
        usaOpenSecondButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        eurOpenSecondButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        chfOpenSecondButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        resultTextView = findViewById(R.id.result_text_view);
        usaOpenSecondButton = findViewById(R.id.usa_currency_open_second_button);
        eurOpenSecondButton = findViewById(R.id.eur_currency_open_second_button);
        chfOpenSecondButton = findViewById(R.id.chf_currency_open_second_button);
    }
}