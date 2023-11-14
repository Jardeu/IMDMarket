package com.jardeu.imdmarket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etLogin;
    EditText etPassword;

    Button btnEntrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = findViewById(R.id.editTextLogin);
        etPassword = findViewById(R.id.editTextPassword);
        btnEntrar = findViewById(R.id.btnEntrar);

        SharedPreferences dados = getSharedPreferences("LoginInformations", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = dados.edit();
        if(dados.getString("login", "").equals("") && dados.getString("senha", "").equals("")){
            editor.putString("login", "admin");
            editor.putString("senha", "admin");
            editor.apply();
        }

        btnEntrar.setOnClickListener(view -> {
            SharedPreferences dados1 = getSharedPreferences("LoginInformations", Context.MODE_PRIVATE);
            if(etLogin.getText().toString().equals(dados1.getString("login", ""))){
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}