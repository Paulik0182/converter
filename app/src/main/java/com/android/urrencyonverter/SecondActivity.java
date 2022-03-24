package com.android.urrencyonverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    public static final String CURRENCY_EXTRA_KEY = "currency";

    private TextView resultSecondTextView = null;
    private EditText inputEditText = null;
    private Button okOpenResultButton = null;
    private Button inputEditButton = null;
    private double currency = 0d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        setListeners();

        Intent intent = getIntent();//принимаем intent с первого окна
        //проверка на наличее значений, далее если значение пришли , выполняется код

        if (intent.hasExtra(CURRENCY_EXTRA_KEY)) {
            currency = intent.getDoubleExtra(CURRENCY_EXTRA_KEY, 0d);//принимаем значения, обновляем currency
        }
    }

    //Метод проверки на формат введенного значения в поле EditText
    private double parseDoubleString(String inputSrt) {
        try {
            return Double.parseDouble(inputSrt);//Приобразовываем ткст в число
        } catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    private void setListeners() {
        okOpenResultButton.setOnClickListener(v -> {
            //Создали переменную, присвоили ей значение текстового поля (достаем введенное значение)
            final String inputSrt = inputEditText.getText().toString();
            // Создали переменную, производим проверку введенного значения, в поле можно ввести только целое число
            // (если в строке будут буквы, служебные символы, компилятор выдаст ошибку. На View в поле EditText прописать
            // строку разрешающую ввод только чисел android:inputType="number",
            // минус данного решения - можно ввести только целое число)
            final double inputValue = parseDoubleString(inputSrt);//приобразуем значение в double
            final double resultValue = convert(inputValue, currency);// считаем полученные значения

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(ResultActivity.VALUE_EXTRA_KEY, resultValue);//передаем получение значение в следующий экран
            startActivity(intent);
        });

        inputEditButton.setOnClickListener(v -> {
            finish();
        });
    }

    //Метод принемающий строку EditText и возващает результат (проходит вычисление)
    private double convert(double value, double currency) {
        return value * currency;
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        resultSecondTextView = findViewById(R.id.result_second_text_view);
        inputEditText = findViewById(R.id.input_edit_text);
        okOpenResultButton = findViewById(R.id.open_result_button);
        inputEditButton = findViewById(R.id.exit_button);
    }
}
