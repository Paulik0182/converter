package com.android.urrencyonverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    public static final String VALUE_EXTRA_KEY = "value";

    private TextView resultTextView = null;
    private Button exitButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initViews();
        setListeners();

        Intent intent = getIntent();//принимаем intent с SecondActivity
        if (intent.hasExtra(VALUE_EXTRA_KEY)) {
            double result = intent.getDoubleExtra(VALUE_EXTRA_KEY, 0d);
            //передаем в поле полученный результат
            resultTextView.setText(String.valueOf(result));
        }
    }

    private void setListeners() {
        exitButton.setOnClickListener(v -> {
            finish();
        });
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        resultTextView = findViewById(R.id.currency_result_text_view);
        exitButton = findViewById(R.id.exit_button);
    }
}
