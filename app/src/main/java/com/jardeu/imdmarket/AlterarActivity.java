package com.jardeu.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlterarActivity extends AppCompatActivity {
    EditText etCodigo, etNome, etDescricao, etEstoque;
    Button btnAlterar, btnLimpar;
    int codigoDoProdutoAlterado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        etCodigo = findViewById(R.id.editTextCodigo2);
        etNome = findViewById(R.id.editTextNome2);
        etDescricao = findViewById(R.id.editTextDescricao2);
        etEstoque = findViewById(R.id.editTextEstoque2);

        btnAlterar = findViewById(R.id.btnSalvarAlteracoes);
        btnLimpar = findViewById(R.id.btnLimpar2);

        btnAlterar.setOnClickListener(view -> {
            salvarAlteracoes();
        });

        btnLimpar.setOnClickListener(view -> {
            etCodigo.setText("");
            etNome.setText("");
            etDescricao.setText("");
            etEstoque.setText("");
        });
    }

    private void salvarAlteracoes(){
        String codigo = etCodigo.getText().toString();
        String nome = etNome.getText().toString();
        String descricao = etDescricao.getText().toString();
        String estoque = etEstoque.getText().toString();

        if(!codigo.isEmpty()){

            for (Produto item : Produto.listaProdutos ) {
                if (item.getCodigo_produto() == Integer.parseInt(codigo)) {
                    codigoDoProdutoAlterado = Integer.parseInt(codigo);
                    if(!nome.isEmpty()) item.setNome_produto(nome);
                    if(!descricao.isEmpty()) item.setDescricao_produto(descricao);
                    if(!estoque.isEmpty()) item.setEstoque(Integer.parseInt(estoque));
                }
            }

            Toast.makeText(this, "Produto alterado com sucesso", Toast.LENGTH_LONG).show();
            finish();
        } else{
            Toast.makeText(this, "O código não pode ser vazio", Toast.LENGTH_LONG).show();
        }
    }
}