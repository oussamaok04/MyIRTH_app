package com.example.irth;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heirs.Person;

import java.util.ArrayList;


public class Calculator extends AppCompatActivity {

    Spinner spsons,spdaughters,spfather,spmother,spfullsisters,sppaternalsisters,spwives,spgrandfather,sppaternalgm,spmaternalgm,txtsons;
    RadioButton rdbtnmale,rdbtnfemale;
    Button btncalcul;
    RadioGroup rggender;
    EditText edtlegacy;
    TextView txtwives;
    String gender = Person.MALE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        txtsons = (Spinner) findViewById(R.id.txtsons);
        txtwives = (TextView) findViewById(R.id.txtwives);
        rdbtnmale = (RadioButton)findViewById(R.id.rdbtnmale);
        rdbtnfemale = (RadioButton)findViewById(R.id.rdbtnfemale);
        edtlegacy = (EditText) findViewById(R.id.edtlegacy);
        spsons = (Spinner)findViewById(R.id.spsons);
        spdaughters = (Spinner)findViewById(R.id.spdaughters);
        spfather = (Spinner)findViewById(R.id.spfather);
        spmother = (Spinner)findViewById(R.id.spmother);
        spfullsisters = (Spinner)findViewById(R.id.spfullsisters);
        sppaternalsisters = (Spinner)findViewById(R.id.sppaternalsisters);
        spwives = (Spinner)findViewById(R.id.spwives);
        spgrandfather = (Spinner) findViewById(R.id.spgrandfather);
        spmaternalgm = (Spinner) findViewById(R.id.spmaternalgm);
        sppaternalgm = (Spinner) findViewById(R.id.sppaternalgm);
        rggender = (RadioGroup) findViewById(R.id.rggender);
        btncalcul = (Button) findViewById(R.id.btncalcul);


        ArrayList<String> number = new ArrayList<>();
        number.add("0");
        number.add("1");
        number.add("2");
        number.add("3");
        number.add("4");
        number.add("5");
        number.add("6");
        number.add("7");
        number.add("8");
        number.add("9");
        number.add("10");
        number.add("11");
        number.add("12");
        number.add("13");
        number.add("14");
        number.add("15");
        number.add("16");
        number.add("17");
        number.add("18");
        number.add("19");
        number.add("20");

        ArrayAdapter<String> numberAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, number);

        spsons.setAdapter(numberAdapter);
        spdaughters.setAdapter(numberAdapter);
        spfullsisters.setAdapter(numberAdapter);
        sppaternalsisters.setAdapter(numberAdapter);

        ArrayList<String> wives = new ArrayList<>();
        wives.add("0");
        wives.add("1");
        wives.add("2");
        wives.add("3");
        wives.add("4");

        ArrayAdapter<String> wivesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,wives);

        spwives.setAdapter(wivesAdapter);

        ArrayList<String> exists = new ArrayList<>();
        exists.add("Yes");
        exists.add("No");

        ArrayAdapter<String> existAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,exists);

        spfather.setAdapter(existAdapter);
        spmother.setAdapter(existAdapter);
        spgrandfather.setAdapter(existAdapter);
        spmaternalgm.setAdapter(existAdapter);
        sppaternalgm.setAdapter(existAdapter);

        ArrayList<String> underthesons = new ArrayList<>();
        underthesons.add("Son");
        underthesons.add("Grandson");
        underthesons.add("Full Brother");
        underthesons.add("Paternal Brother");
        underthesons.add("Maternal Brother");
        underthesons.add("Maternal Sister");
        underthesons.add("Nephew");
        underthesons.add("Paternal Nephew");
        underthesons.add("Nephew's Son");
        underthesons.add("Paternal Nephew's Son");
        underthesons.add("Uncle");
        underthesons.add("Paternal Uncle");
        underthesons.add("Cousin");
        underthesons.add("Paternal Cousin");
        underthesons.add("Cousin's Son");
        underthesons.add("Paternal Cousin's Son");

        ArrayAdapter<String> underthesonsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, underthesons);

        txtsons.setAdapter(underthesonsAdapter);


        rggender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rdbtnfemale:
                        txtwives.setText("Husband");
                        spwives.setAdapter(existAdapter);
                        gender = Person.FEMALE;
                        break;
                    case R.id.rdbtnmale:
                        txtwives.setText("Wives");
                        spwives.setAdapter(wivesAdapter);
                        gender = Person.MALE;
                        break;
                    default:
                        break;
                }

            }
        });


        btncalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtlegacy.getText().toString().equals("")){
                    Toast.makeText(Calculator.this, "Plz Enter Legacy Value!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(intent);
                }
            }
        });



    }
    public String getgender(){
        return this.gender;
    }

    public double getlegacy(){
        return Double.parseDouble(edtlegacy.getText().toString());
    }

    public int getsonsnb(){
        if (txtsons.getSelectedItem().toString().equals("Son")){
            return Integer.parseInt(spsons.getSelectedItem().toString());
        }
        else
            return 0;
    }

    public int getgrandsonsnb(){
        if (txtsons.getSelectedItem().toString().equals("Grandson")){
            return Integer.parseInt(spsons.getSelectedItem().toString());
        }
        else
            return 0;
    }

    public int getfullbrothernb(){
        if (txtsons.getSelectedItem().toString().equals("Son")){
            return Integer.parseInt(spsons.getSelectedItem().toString());
        }
        else
            return 0;
    }
}