package com.example.bunnychiu.atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText ed_username;
    private EditText ed_password;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edusername = findViewById(R.id.ed_username);
        String username = getSharedPreferences("atm",MODE_PRIVATE)
                .getString("USERNAME","");
        edusername.setText(username);
    }

    public void login(View view) {
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        username = ed_username.getText().toString();
        password = ed_password.getText().toString();
        if ("juty123321".equals(username) && "123456789".equals(password)) { //登入成功
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit().putString("USERID",username).apply();
            finish();
        }else{ //登入失敗
            new AlertDialog.Builder(this)
                    .setTitle("Atm")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();

        }
    }

    public void cancel(View view){

    }
}

