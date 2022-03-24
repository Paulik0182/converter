package com.android.urrencyonverter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SECOND_SCREEN_REQUEST = 100;

    private static final int RUB_IN_USD = 30;
    private static final int RUB_IN_EUR = 40;
    private static final int RUB_IN_CHF = 10;

    private Button usaOpenSecondButton = null;
    private Button eurOpenSecondButton = null;
    private Button chfOpenSecondButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
    }

    private void setListeners() {
        usaOpenSecondButton.setOnClickListener(v -> openResultScreen(RUB_IN_USD));
        eurOpenSecondButton.setOnClickListener(v -> openResultScreen(RUB_IN_EUR));
        chfOpenSecondButton.setOnClickListener(v -> openResultScreen(RUB_IN_CHF));
    }

    private void openResultScreen(double currency) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.CURRENCY_EXTRA_KEY, currency);//значение - стоимость волюты
        startActivity(intent);
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        usaOpenSecondButton = findViewById(R.id.usa_currency_open_second_button);
        eurOpenSecondButton = findViewById(R.id.eur_currency_open_second_button);
        chfOpenSecondButton = findViewById(R.id.chf_currency_open_second_button);
    }
}