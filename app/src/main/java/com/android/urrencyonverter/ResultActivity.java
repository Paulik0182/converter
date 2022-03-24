package com.android.urrencyonverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    public static final String VALUE_EXTRA_KEY = "value";

    private TextView currencyResultTextView = null;
    private Button exitButton = null;
    private double result = 0d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initViews();
        setListeners();

        Intent intent = getIntent();//принимаем intent с SecondActivity
        if (intent.hasExtra(VALUE_EXTRA_KEY)) {
            result = intent.getDoubleExtra(VALUE_EXTRA_KEY, 0d);
            //передаем в поле полученный результат
            currencyResultTextView.setText(String.valueOf(result));
        }
    }

    private void setListeners() {
        exitButton.setOnClickListener(v -> {
            Intent dataIntent = new Intent();
            dataIntent.putExtra(VALUE_EXTRA_KEY, result);
            setResult(Activity.RESULT_OK, dataIntent);
            finish();
        });
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        currencyResultTextView = findViewById(R.id.currency_result_text_view);
        exitButton = findViewById(R.id.exit_button);
    }
}
