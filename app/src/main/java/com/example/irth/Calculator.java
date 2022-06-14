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

import com.example.heirs.Deceased;
import com.example.heirs.Heir;
import com.example.heirs.Person;
import com.example.rules.StandardRules;

import java.util.ArrayList;
import java.util.List;


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
        exists.add("0");
        exists.add("1");

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
                        txtwives.setText("Wife");
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
                    Toast.makeText(Calculator.this, "Please Enter Legacy Value!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Heir h1,daughter,father,mother,fsister,psister,spouse,gfather,mgmother,pgmother;

                    h1 = new Heir(txtsons.getSelectedItem().toString(), Integer.parseInt(spsons.getSelectedItem().toString()));
                    daughter = new Heir("Daughter", Integer.parseInt(spdaughters.getSelectedItem().toString()));
                    father = new Heir("Father", Integer.parseInt(spfather.getSelectedItem().toString()));
                    mother = new Heir("Mother", Integer.parseInt(spfather.getSelectedItem().toString()));
                    fsister = new Heir("Full Sister", Integer.parseInt(spfather.getSelectedItem().toString()));
                    psister = new Heir("Paternal Sister", Integer.parseInt(spfather.getSelectedItem().toString()));
                    spouse = new Heir(txtwives.getText().toString(), Integer.parseInt(spfather.getSelectedItem().toString()));
                    gfather = new Heir("Grandfather", Integer.parseInt(spfather.getSelectedItem().toString()));
                    mgmother = new Heir("Maternal Grandmother", Integer.parseInt(spfather.getSelectedItem().toString()));
                    pgmother = new Heir("Paternal Grandmother", Integer.parseInt(spfather.getSelectedItem().toString()));

                    Deceased deceased = new Deceased(getgender(), getlegacy());

                    deceased.addHeir(h1);
                    deceased.addHeir(daughter);
                    deceased.addHeir(father);
                    deceased.addHeir(mother);
                    deceased.addHeir(fsister);
                    deceased.addHeir(psister);
                    deceased.addHeir(spouse);
                    deceased.addHeir(gfather);
                    deceased.addHeir(mgmother);
                    deceased.addHeir(pgmother);

                    double h1portion = 0.0;
                    double daughterportion = 0.0;
                    double fsisterportion = 0.0;
                    double psisterportion = 0.0;
                    double fatherportion = 0.0;
                    double motherportion = 0.0;
                    double spouseportion = 0.0;
                    double gfatherportion = 0.0;
                    double mgmotherportion = 0.0;
                    double pgmotherportion = 0.0;


                    h1portion = firstheirportion(deceased, txtsons.getSelectedItem().toString());
                    daughterportion = StandardRules.getDaughterportion(deceased);
                    fatherportion = StandardRules.getFatherportion(deceased);
                    motherportion = StandardRules.getMotherportion(deceased);
                    fsisterportion = StandardRules.getFullSisterportion(deceased);
                    psisterportion = StandardRules.getPaternalBrotherportion(deceased);
                    spouseportion = getspouseportion(deceased);
                    gfatherportion = StandardRules.getGrandFatherportion(deceased);
                    mgmotherportion = StandardRules.getMaternalGrandMotherportion(deceased);
                    pgmotherportion = StandardRules.getPaternalGrandMotherportion(deceased);

                    h1.setinheritedvalue(h1portion);
                    daughter.setinheritedvalue(daughterportion);
                    father.setinheritedvalue(fatherportion);
                    mother.setinheritedvalue(motherportion);
                    fsister.setinheritedvalue(fsisterportion);
                    psister.setinheritedvalue(psisterportion);
                    spouse.setinheritedvalue(spouseportion);
                    gfather.setinheritedvalue(gfatherportion);
                    mgmother.setinheritedvalue(mgmotherportion);
                    pgmother.setinheritedvalue(pgmotherportion);

                    String heir1 = txtsons.getSelectedItem().toString();
                    String spousename = txtwives.getText().toString();


                    DBHelper db = new DBHelper(Calculator.this);
                    List<Heir> theheirs = deceased.getHeirs();
                    for (Heir heir : theheirs) {
                        db.addheirs(heir);
                    }
                    db.adddeceased(deceased);

                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("heir1name", heir1);
                    intent.putExtra("spousename", spousename);
                    intent.putExtra("portion1", h1portion);
                    intent.putExtra("portion1", daughterportion);
                    intent.putExtra("portion1", fatherportion);
                    intent.putExtra("portion1", motherportion);
                    intent.putExtra("portion1", fsisterportion);
                    intent.putExtra("portion1", psisterportion);
                    intent.putExtra("portion1", spouseportion);
                    intent.putExtra("portion1", gfatherportion);
                    intent.putExtra("portion1", mgmotherportion);
                    intent.putExtra("portion1", pgmotherportion);
                    startActivity(intent);
                }
            }

            public double getspouseportion(Deceased deceased){
                double portion = 0.0;
                if (deceased.getGender().equals(Person.FEMALE)){
                    portion = StandardRules.getHusbandportion(deceased);
                }
                else {
                    portion = StandardRules.getWifeportion(deceased, Integer.parseInt(spwives.getSelectedItem().toString()));
                }
                return portion;
            }

            public double firstheirportion(Deceased deceased, String heirtype){
                double portion = 0.0;
                switch (heirtype){
                    case "Son":
                        portion = StandardRules.getSonPortion(deceased);
                        break;
                    case "Grandson":
                        portion = StandardRules.getGrandsonportion(deceased);
                        break;
                    case "Fullbrother":
                        portion = StandardRules.getFullBrotherportion(deceased);
                    case "Paternal Brother":
                        portion = StandardRules.getPaternalBrotherportion(deceased);
                        break;
                    case "Maternal Brother":
                        portion = StandardRules.getMaternalSiblingportion(deceased);
                        break;
                    case "Maternal Sister":
                        portion = StandardRules.getMaternalSiblingportion(deceased);
                        break;
                    case "Nephew":
                        portion = StandardRules.getNephewportion(deceased);
                        break;
                    case "Paternal Nephew":
                        portion = StandardRules.getPaternalNephewportion(deceased);
                        break;
                    case "Nephew's Son":
                        portion = StandardRules.getNephewSonportion(deceased);
                        break;
                    case "Paternal Nephew's Son":
                        portion = StandardRules.getPaternalNephewSonportion(deceased);
                        break;
                    case "Uncle":
                        portion = StandardRules.getUncleportion(deceased);
                        break;
                    case "Paternal Uncle":
                        portion = StandardRules.getPaternalUncleportion(deceased);
                        break;
                    case "Cousin":
                        portion = StandardRules.getCousinportion(deceased);
                        break;
                    case "Paternal Cousin":
                        portion = StandardRules.getPaternalCousinSonportion(deceased);
                        break;
                    case "Cousin's Son":
                        portion = StandardRules.getCousinSonportion(deceased);
                        break;
                    case "Paternal Cousin's Son":
                        portion = StandardRules.getPaternalCousinSonportion(deceased);
                        break;
                    default:
                        portion = StandardRules.getSonPortion(deceased);
                }

                return portion;
            }


        });



    }

    public String getgender(){
        return this.gender;
    }

    public double getlegacy(){
        return Double.parseDouble(edtlegacy.getText().toString());
    }


}