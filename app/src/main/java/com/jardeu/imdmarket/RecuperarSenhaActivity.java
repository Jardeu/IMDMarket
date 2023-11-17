package com.jardeu.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecuperarSenhaActivity extends AppCompatActivity {
    EditText etLogin, etPassword;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        etLogin = findViewById(R.id.editTextLogin2);
        etPassword = findViewById(R.id.editTextNewPassword);
        btnSalvar = findViewById(R.id.btnSalvarNovaSenha);

        btnSalvar.setOnClickListener(view -> {
            SharedPreferences dados = getSharedPreferences("LoginInformations", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = dados.edit();
            if(etLogin.getText().toString().equals(dados.getString("login", "")))
            {
                editor.putString("senha", etPassword.getText().toString());
                editor.apply();
                Toast.makeText(this, "Senha alterada com sucesso", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "Digite o login correto", Toast.LENGTH_LONG).show();
            }
        });
    }
}