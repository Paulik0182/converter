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

    //Метод проверки на формат введенного значения в поле EditText
    private double parseDoubleString(String inputSrt) {
        try {
            return Double.parseDouble(inputSrt);//Приобразовываем ткст в число
        } catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    private void openResultScreen() {
        //Создали переменную, присвоили ей значение текстового поля
        final String inputSrt = inputEditText.getText().toString();
        // Создали переменную, производим проверку введенного значения, в поле можно ввести только целое число
        // (если в строке будут буквы, служебные символы, компилятор выдаст ошибку. На View в поле EditText прописать
        // строку разрешающую ввод только чисел android:inputType="number",
        // минус данного решения - можно ввести только целое число)
        final double value = parseDoubleString(inputSrt);

        okOpenResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(ResultActivity.VALUE_EXTRA_KEY, value);//введенное значение в строку EditText - сколько волюты нужно конвертировать
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
