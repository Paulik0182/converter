package com.android.urrencyonverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    public static final String USD_CURRENCY_EXTRA_KEY = "USD";
    public static final String EUR_CURRENCY_EXTRA_KEY = "EUR";
    public static final String CHF_CURRENCY_EXTRA_KEY = "CHF";
    public static final String VALUE_EXTRA_KEY = "value";

    private TextView resultTextView = null;
    private Button exitButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initViews();
        openResultScreen();

        Intent intent = getIntent();//принимаем intent с первого окна
        //проверка на наличее значений, далее если значение пришли , выполняется код

        if (intent.hasExtra(USD_CURRENCY_EXTRA_KEY) && intent.hasExtra(VALUE_EXTRA_KEY)) {
            double currency = intent.getDoubleExtra(USD_CURRENCY_EXTRA_KEY, 0d);//принимаем значения
            double value = intent.getDoubleExtra(VALUE_EXTRA_KEY, 0d);//принимаем значения

            //присвоили переменной результат вычисления в методе convert, передали пришедшие значения в метод convert
            double result = convert(value, currency);
            //передаем в поле полученный результат
            resultTextView.setText(String.valueOf(result));
        }
    }

    //Метод принемающий строку EditText и возващает результат (проходит вычисление)
    private double convert(double value, double currency) {
        return value * currency;
    }

    private void openResultScreen() {
        exitButton.setOnClickListener(v -> {
            finish();
        });
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        resultTextView = findViewById(R.id.result_text_view);
        exitButton = findViewById(R.id.exit_button);
    }
}
