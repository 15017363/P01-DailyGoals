package com.example.a15017363.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    EditText etReflection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Daily Goals");


        rg1 = (RadioGroup)findViewById(R.id.RadioGroup1);
        rg2 = (RadioGroup)findViewById(R.id.RadioGroup2);
        rg3 = (RadioGroup)findViewById(R.id.RadioGroup3);

        etReflection = (EditText)findViewById(R.id.editTextReflection);


        Button btnOk = (Button)findViewById(R.id.buttonOk);
        Button btnReset = (Button)findViewById(R.id.buttonReset);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Get the id of the selected radio button in the RadioGroup
                int selectedButtonidRead = rg1.getCheckedRadioButtonId();
                int selectedButtonidArrive = rg2.getCheckedRadioButtonId();
                int selectedButtonidAttempt = rg3.getCheckedRadioButtonId();


                //Get the radio button object from the Id we have gotten above
                RadioButton rbRead = (RadioButton)findViewById(selectedButtonidRead);
                RadioButton rbArrive = (RadioButton)findViewById(selectedButtonidArrive);
                RadioButton rbAttempt = (RadioButton)findViewById(selectedButtonidAttempt);


//                //Show a toast that display the text on the selected radio button
//                Toast.makeText(getBaseContext(), "Good day!",
//                        Toast.LENGTH_SHORT).show();


                String reflection = etReflection.getText().toString();

                String [] info = {rbRead.getText().toString(), rbArrive.getText().toString(),
                        rbAttempt.getText().toString(), reflection };

                //Create an intent to start another activity called
                //DemoActivities (which we would create later)

                Intent i = new Intent(MainActivity.this , DailyGoals2.class);

                //Pass the String Array holding the name & age to new activity
                i.putExtra("info", info);
                startActivity(i);

                SharedPreferences prefs = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putInt("Read",selectedButtonidRead);
                prefEdit.putInt("Arrive",selectedButtonidArrive);
                prefEdit.putInt("Attempt",selectedButtonidAttempt);
                prefEdit.putString("Reflection",reflection);

                prefEdit.commit();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg1.clearCheck();
                rg2.clearCheck();
                rg3.clearCheck();
                etReflection.setText("");

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);

    int checked1 = prefs.getInt("Read", 0);
    int checked2 = prefs.getInt("Arrive", 0);
    int checked3 = prefs.getInt("Attempt", 0);
    String reflection = prefs.getString("Reflection", "");
    rg1.check(checked1);
    rg2.check(checked2);
    rg3.check(checked3);
    etReflection.setText(reflection);

    }




//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences prefs = PreferenceManager
//                .getDefaultSharedPreferences(this);
//
//        int checked = prefs.getInt("Read",0);
//        rg1.check(checked);
//
//
//    }
}
