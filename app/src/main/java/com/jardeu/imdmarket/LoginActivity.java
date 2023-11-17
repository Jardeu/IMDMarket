package com.jardeu.imdmarket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText etLogin, etPassword;
    Button btnEntrar, btnRecuperarSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = findViewById(R.id.editTextLogin);
        etPassword = findViewById(R.id.editTextPassword);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnRecuperarSenha = findViewById(R.id.btnRecuperarSenha);

        SharedPreferences dados = getSharedPreferences("LoginInformations", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = dados.edit();
        if(dados.getString("login", "").equals("") && dados.getString("senha", "").equals("")){
            editor.putString("login", "admin");
            editor.putString("senha", "admin");
            editor.apply();
        }

        BancoAdmin admin = new BancoAdmin(this, "BancoProdutos", null, 1);
        SQLiteDatabase banco = admin.getWritableDatabase();

        BancoAdmin.lerDadosBanco(banco);

        btnEntrar.setOnClickListener(view -> {
            if(etLogin.getText().toString().equals(dados.getString("login", ""))
                    && etPassword.getText().toString().equals(dados.getString("senha", "")))
            {
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Login ou Senha está incorreto", Toast.LENGTH_LONG).show();
            }
        });

        btnRecuperarSenha.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
            startActivity(intent);
        });
    }
}