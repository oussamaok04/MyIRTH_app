package com.example.irth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.resources.TextAppearance;

public class RulesActivity extends AppCompatActivity {


    TextView rules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        rules = (TextView) findViewById(R.id.rulestxt);
    }
}