package com.example.genlanzer.tipcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SatisfactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satisfaction);
    }

    public void calculate(View view) {
        EditText ratingText = findViewById(R.id.rating_edit_id);
        String rating = ratingText.getText().toString();

        Intent intent = new Intent();

        if (!TextUtils.isEmpty(ratingText.getText())) {
            if(Integer.parseInt(ratingText.getText().toString()) <= 5 && Integer.parseInt(ratingText.getText().toString()) >= 1) {
                intent.putExtra("tip_percentage", rating);
                setResult(RESULT_OK, intent);
                finish();
            }
            else{
                Context context = getApplicationContext();
                CharSequence text = "Rating must be between 1 and 5 inclusively";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 450);
                toast.show();

            }
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "This field is mandatory";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 450);
            toast.show();

        }
    }

}
