package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String check = "";
    TextView panel;
    private double peroeChislo, rezultat, vtoroeChislo;
    private String operation = "";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panel = findViewById(R.id.text_view);

    }

    /**
     * Людвиг Ленивый "приносит информацию из сундука"
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        panel.setText(savedInstanceState.getString("result"));
        peroeChislo = savedInstanceState.getDouble("peroeChislo");
        operation = savedInstanceState.getString("operation");
    }

    /**
     * сундук с информацией "тут хронятся цифры"
     */

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result", panel.getText().toString());
        outState.putDouble("peroeChislo", peroeChislo);
        outState.putString("operation", operation);

    }

    /**
     * тут мы вызываем кнопки из xml "из окна с кнопками"
     */

    public void onClick_Btn(View view) {
        switch (view.getId()) {

            case R.id.zero:
                check += "0";
                break;

            case R.id.one_btn:
                check += "1";
                break;

            case R.id.two:
                check += "2";
                break;

            case R.id.tri:
                check += "3";
                break;

            case R.id.chturi:
                check += "4";
                break;

            case R.id.pati:
                check += "5";
                break;

            case R.id.hesti:
                check += "6";
                break;

            case R.id.semi:
                check += "7";
                break;

            case R.id.wosem:
                check += "8";
                break;

            case R.id.dewati:
                check += "9";
                break;

            case R.id.delete:
                check = "";
                break;

            case R.id.tochka:
                check += ".";
                break;

        }

        panel.setText(check);


    }

    /**
     * тут мы прописываем что делают вычислительные знаки
     */

    public void Logic_onClick(View view) {

        switch (view.getId()) {

            case R.id.plus:
                peroeChislo = Double.parseDouble(check);
                check = "";
                operation = "+";
                panel.setText("+");

                break;
            case R.id.minus:
                peroeChislo = Double.parseDouble(check);
                check = "";
                operation = "-";
                panel.setText("-");

                break;
            case R.id.umnojenie:
                peroeChislo = Double.parseDouble(check);
                check = "";
                operation = "*";
                panel.setText("*");

                break;
            case R.id.delenie:
                peroeChislo = Double.parseDouble(check);
                check = "";
                operation = "/";
                panel.setText("/");

                break;

            case R.id.rawno:
                vtoroeChislo = Double.parseDouble(check);
                switch (operation) {
                    case "/":
                        rezultat = peroeChislo / vtoroeChislo;
                        break;
                    case "*":
                        rezultat = peroeChislo * vtoroeChislo;
                        break;
                    case "+":
                        rezultat = peroeChislo + vtoroeChislo;
                        break;
                    case "-":
                        rezultat = peroeChislo - vtoroeChislo;
                        break;
                }
                panel.setText(rezultat + "");
                break;
        }
    }

    public void onBackBtn(View view) {
        Intent intent = getIntent();
        intent.putExtra("result", rezultat);
        setResult(RESULT_OK,intent);
        finish();
    }
}