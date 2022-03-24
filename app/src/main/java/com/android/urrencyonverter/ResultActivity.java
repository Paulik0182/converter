package com.android.urrencyonverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    public static final String CURRENCY_EXTRA_KEY = "result";

    public TextView resultTextView = null;
    private Button exitButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initViews();
        setListeners();

        Intent intent = getIntent();//принимаем intent с первого окна
        if (intent.hasExtra(CURRENCY_EXTRA_KEY)) {
            //присвоили переменной результат вычисления в методе convert, передали пришедшие значения в метод convert
            double result = intent.getDoubleExtra(CURRENCY_EXTRA_KEY, 0d);
            //передаем в поле полученный результат
            resultTextView.setText(String.valueOf(result));
        }
    }

//    //Метод принемающий строку EditText и возващает результат (проходит вычисление)
//    private double convert(double value, double currency) {
//        return value * currency;
//    }

    private void setListeners() {
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
