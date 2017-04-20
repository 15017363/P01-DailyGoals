package com.example.a15017363.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DailyGoals2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_goals2);

        getSupportActionBar().setTitle("Summary");


        //Get the intent so as to get the "things inside the intent
        Intent i = getIntent();
        //Get the string array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        //Get the textview Object
        TextView tv1 = (TextView)findViewById(R.id.textViewSummary);
        //Display the name and age on the Textview
        tv1.setText("Read up on materials before class: "+info[0] +
                "\nArrive on time so as not to miss important part of the lesson: "+info[1] +
                "\nAttempt the problem myself: "+info[2] +
                "\nReflection: "+info[3]);


        Button btnBack = (Button)findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent a = new Intent(DailyGoals2.this, MainActivity.class);
//                startActivity(a);
                onBackPressed();

            }
        });
    }


}
