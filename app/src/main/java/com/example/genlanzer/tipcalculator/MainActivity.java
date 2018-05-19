package com.example.genlanzer.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void calculatetip(View view)
    {
        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
        EditText totalText = findViewById(R.id.subtotal_id);
        EditText tipText = findViewById(R.id.tip_percentage_id);
        EditText personsText = findViewById(R.id.persons_id);

        intent.putExtra("subtotal", ""+totalText.getText());
        intent.putExtra("tip", ""+tipText.getText());
        intent.putExtra("persons", ""+personsText.getText());


        startActivity(intent);
    }





    public void calculatepercentage(View view) {

        // Start the SecondActivity
        Intent intent = new Intent(this, SatisfactionActivity.class);
        startActivityForResult(intent, 1);
    }

    // This method is called when the second activity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {


                int tip_percentage = 10 + (2 * Integer.parseInt(data.getStringExtra("tip_percentage")));
                EditText tip = findViewById(R.id.tip_percentage_id);
                tip.setText("" + tip_percentage);
            }
        }


    }

        public void goToSettings(View view) {

            // Start the SecondActivity
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }









}
