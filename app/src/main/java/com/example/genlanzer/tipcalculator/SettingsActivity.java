package com.example.genlanzer.tipcalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPreferences", MODE_PRIVATE);

        int currency = sharedPreferences.getInt("CurrencyInt", R.id.dollar_id);
        RadioGroup radioGroup = findViewById(R.id.radio);
        radioGroup.check(currency);
        String tip = sharedPreferences.getString("Tip", "");
        EditText tipText = findViewById(R.id.default_tip_edit_id);
        tipText.setText(tip);



    }

    
    public void apply(View view) {
        Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
        RadioGroup radioGroup = findViewById(R.id.radio);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);

        String currency = radioButton.getText().toString();
        EditText tip = findViewById(R.id.default_tip_edit_id);
        String tipString = tip.getText().toString();


        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPreferences", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Tip",tipString);
        editor.putString("Currency",currency);
        editor.putInt("CurrencyInt",selectedId);

        editor.apply();
        startActivity(intent);










    }



}
