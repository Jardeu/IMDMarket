package com.jardeu.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnCadastrar, btnListar, btnAlterar, btnDeletar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnListar = findViewById(R.id.btnListar);
        btnAlterar = findViewById(R.id.btnAlterar);
        btnDeletar = findViewById(R.id.btnDeletar);

        btnCadastrar.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        btnListar.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, ListarActivity.class);
            startActivity(intent);
        });

        btnAlterar.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, AlterarActivity.class);
            startActivity(intent);
        });

        btnDeletar.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, DeletarActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        BancoAdmin admin = new BancoAdmin(this, "BancoProdutos", null, 1);
        SQLiteDatabase banco = admin.getWritableDatabase();

        BancoAdmin.salvarDadosBanco(banco);
    }
}