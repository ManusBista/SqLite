package com.example.loginandreg;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


    public class Login extends AppCompatActivity {
        Button btn_lregister, btn_llogin;
        EditText et_lusername, et_lpassword;

        DatabaseHelper databaseHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            databaseHelper = new DatabaseHelper(this);

            et_lusername = (EditText)findViewById(R.id.et_lusername);
            et_lpassword = (EditText)findViewById(R.id.et_lpassword);

            btn_llogin = (Button)findViewById(R.id.btn_llogin);
            btn_lregister = findViewById(R.id.btn_lregister);

            btn_lregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            btn_llogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username = et_lusername.getText().toString();
                    String password = et_lpassword.getText().toString();

                    Boolean checklogin = databaseHelper.CheckLogin(username, password);
                    if(checklogin == true){
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }