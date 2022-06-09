package com.example.irth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {

    TextView logo;
    MaterialButton introbtn, calculbtn, rulesbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logo = (TextView) findViewById(R.id.logotxt);
        introbtn = (MaterialButton) findViewById(R.id.introbtn);
        calculbtn = (MaterialButton) findViewById(R.id.calculbtn);
        rulesbtn = (MaterialButton) findViewById(R.id.rulesbtn);


        introbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),IntroActivity.class);
                startActivity(intent);
            }
        });

        calculbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Calculator.class);
                startActivity(intent);
            }
        });

        rulesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RulesActivity.class);
                startActivity(intent);
            }
        });
    }
}