package com.example.irth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    MaterialButton loginbtn, registerbtn;
    TextView txtor;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.edtxtusename);
        password = (EditText) findViewById(R.id.edtxtpassword);
        loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        registerbtn = (MaterialButton) findViewById(R.id.registerbtn);
        db = new DBHelper(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter the empty fields !", Toast.LENGTH_LONG).show();
                }else{
                    Boolean checkuserpass = db.checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(MainActivity.this, "Sign in successfull !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "Invalid informations. Try again !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}