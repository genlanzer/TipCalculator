package com.example.genlanzer.tipcalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        Double subtotal = Double.parseDouble(intent.getStringExtra("subtotal"));
        Double tip = Double.parseDouble(intent.getStringExtra("tip"));
        Double persons = Double.parseDouble(intent.getStringExtra("persons"));

        tip = subtotal*(tip/100);
        Double total = subtotal+tip;
        Double tipPP = tip/persons;
        Double totalPP = total/persons;

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        String currency = sharedPreferences.getString("Currency", "$");



        EditText subtotalText = findViewById(R.id.subtotal_next_id);
        subtotalText.setText(""+subtotal+currency);
        EditText tipText = findViewById(R.id.tip_amount_id);
        tipText.setText(""+tip+currency);
        EditText totalText = findViewById(R.id.total_id);
        totalText.setText(""+total+currency);

        EditText tipPPText = findViewById(R.id.tipPP_id);
        tipPPText.setText(""+tipPP+currency);
        EditText totalPPText = findViewById(R.id.totalPP_id);
        totalPPText.setText(""+totalPP+currency);






    }



}







