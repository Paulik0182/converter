package com.android.urrencyonverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    public static final String USD_CURRENCY_EXTRA_KEY = "USD";
    public static final String EUR_CURRENCY_EXTRA_KEY = "EUR";
    public static final String CHF_CURRENCY_EXTRA_KEY = "CHF";
    public static final String VALUE_EXTRA_KEY = "value";

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

        Intent intent = getIntent();//принимаем intent с первого окна
        //проверка на наличее значений, далее если значение пришли , выполняется код

        if (intent.hasExtra(USD_CURRENCY_EXTRA_KEY) && intent.hasExtra(VALUE_EXTRA_KEY)) {
            double currency = intent.getDoubleExtra(USD_CURRENCY_EXTRA_KEY, 0d);//принимаем значения
            double value = intent.getDoubleExtra(VALUE_EXTRA_KEY, 0d);//принимаем значения

            //присвоили переменной результат вычисления в методе convert, передали пришедшие значения в метод convert
            double result = convert(value, currency);

            Intent intent1 = new Intent(this, ResultActivity.class);
            //при открытии второго окна кладем дополнительные значения в формате: ключь, значение.
            intent.putExtra(ResultActivity.RESULT_CURRENCY_EXTRA_KEY, result);//значение - стоимость волюты
            startActivity(intent1);
        }
    }

    //Метод принемающий строку EditText и возващает результат (проходит вычисление)
    private double convert(double value, double currency) {
        return value * currency;
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
            intent.putExtra(SecondActivity.VALUE_EXTRA_KEY, value);//введенное значение в строку EditText - сколько волюты нужно конвертировать
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
