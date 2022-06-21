package com.example.irth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ResultActivity extends AppCompatActivity {

    TextView result,legacy,heir1, heir2, heir3, heir4 ,heir5, heir6, heir7, heir8, heir9, heir10, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
    String string;
    MaterialButton btnmodifier;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnmodifier = (MaterialButton) findViewById(R.id.btnmodifier);

        result = (TextView) findViewById(R.id.titleresult);

        legacy = (TextView) findViewById(R.id.lamounth);

        heir1 = (TextView) findViewById(R.id.heir1txt);
        heir2 = (TextView) findViewById(R.id.heir2txt);
        heir3 = (TextView) findViewById(R.id.heir3txt);
        heir4 = (TextView) findViewById(R.id.heir4txt);
        heir5 = (TextView) findViewById(R.id.heir5txt);
        heir6 = (TextView) findViewById(R.id.heir6txt);
        heir7 = (TextView) findViewById(R.id.heir7txt);
        heir8 = (TextView) findViewById(R.id.heir8txt);
        heir9 = (TextView) findViewById(R.id.heir9txt);
        heir10 = (TextView) findViewById(R.id.heir10txt);

        p1 = (TextView) findViewById(R.id.portion1txt);
        p2 = (TextView) findViewById(R.id.portion2txt);
        p3 = (TextView) findViewById(R.id.portion3txt);
        p4 = (TextView) findViewById(R.id.portion4txt);
        p5 = (TextView) findViewById(R.id.portion5txt);
        p6 = (TextView) findViewById(R.id.portion6txt);
        p7 = (TextView) findViewById(R.id.portion7txt);
        p8 = (TextView) findViewById(R.id.portion8txt);
        p9 = (TextView) findViewById(R.id.portion9txt);
        p10 = (TextView) findViewById(R.id.portion10txt);

        String l = getIntent().getStringExtra("legacy");
        String h1 = getIntent().getStringExtra("heir1name");
        String pn1 = getIntent().getStringExtra("portion1");
        String pn2 = getIntent().getStringExtra("portion2");
        String pn3 = getIntent().getStringExtra("portion3");
        String pn4 = getIntent().getStringExtra("portion4");
        String pn5 = getIntent().getStringExtra("portion5");
        String pn6 = getIntent().getStringExtra("portion6");
        String pn7 = getIntent().getStringExtra("portion7");
        String pn8 = getIntent().getStringExtra("portion8");
        String pn9 = getIntent().getStringExtra("portion9");
        String pn10 = getIntent().getStringExtra("portion10");


        legacy.setText(l);
        heir1.setText(h1);
        p1.setText(pn1);
        p2.setText(pn2);
        p3.setText(pn3);
        p4.setText(pn4);
        p5.setText(pn5);
        p6.setText(pn6);
        p7.setText(pn7);
        p8.setText(pn8);
        p9.setText(pn9);
        p10.setText(pn10);


        string = result.getText().toString()+"\n\n"
                + heir1.getText().toString()+"\t"+p1.getText().toString()+"\n"
                + heir2.getText().toString()+"\t"+p2.getText().toString()+"\n"
                + heir3.getText().toString()+"\t"+p3.getText().toString()+"\n"
                + heir4.getText().toString()+"\t"+p4.getText().toString()+"\n"
                + heir5.getText().toString()+"\t"+p5.getText().toString()+"\n"
                + heir6.getText().toString()+"\t"+p6.getText().toString()+"\n"
                + heir7.getText().toString()+"\t"+p7.getText().toString()+"\n"
                + heir8.getText().toString()+"\t"+p8.getText().toString()+"\n"
                + heir9.getText().toString()+"\t"+p9.getText().toString()+"\n"
                + heir10.getText().toString()+"\t"+p10.getText().toString()+"\n";

        btnmodifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calculator.class);
                startActivity(intent);
            }
        });



    }
}