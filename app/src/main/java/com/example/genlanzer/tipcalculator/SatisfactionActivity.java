package com.example.genlanzer.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SatisfactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satisfaction);
    }


    public void calculate(View view) {
        EditText ratingText = findViewById(R.id.rating_edit_id);
        String stringToPassBack = ratingText.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("tip_percentage", stringToPassBack);
        setResult(RESULT_OK, intent);
        finish();




    }
}



    // put the String to pass back into an Intent and close this activity
