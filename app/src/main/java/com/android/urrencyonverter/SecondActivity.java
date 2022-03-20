package com.android.urrencyonverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView resultSecondTextView = null;
    private EditText inputEditText = null;
    private Button okOpenResultButton = null;
    private Button inputEditButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        openResultScreen();
    }

    private void openResultScreen() {
        okOpenResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ResultActivity.class);
            startActivity(intent);
        });

        inputEditButton.setOnClickListener(v -> {
            finish();
        });
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        resultSecondTextView = findViewById(R.id.result_second_text_view);
        inputEditText = findViewById(R.id.input_edit_text);
        okOpenResultButton = findViewById(R.id.open_result_button);
        inputEditButton = findViewById(R.id.exit_button);
    }
}
