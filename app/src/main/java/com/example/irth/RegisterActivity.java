package com.example.irth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    TextView hasaccount;
    EditText username, password, repassword;
    MaterialButton signup, signin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        hasaccount = (TextView) findViewById(R.id.txthasaccount);
        username = (EditText) findViewById(R.id.edtxtregusername);
        password = (EditText) findViewById(R.id.edtxtregpass);
        repassword = (EditText) findViewById(R.id.edtxtregrepass);
        signup = (MaterialButton) findViewById(R.id.signupbtn);
        signin = (MaterialButton) findViewById(R.id.signinpagebtn);
        db = new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(RegisterActivity.this, "Please enter all the empty fields", Toast.LENGTH_LONG).show();

                }else{
                    if (pass.equals(repass)){
                        Boolean checkuser = db.checkusername(user);
                        if (checkuser==false){
                            Boolean insert = db.insertData(user, pass);
                            if (insert==true){
                                Toast.makeText(RegisterActivity.this, "Registered Successfully !", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registration Failed !", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this, "Username already exists. Please go to the LOGIN page !", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Passwords and Confirm Password must be the same !", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}