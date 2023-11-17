package com.jardeu.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {
    EditText etCodigo, etNome, etDescricao, etEstoque;
    Button btnSalvar, btnLimpar;
    Produto produto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etCodigo = findViewById(R.id.editTextCodigo);
        etNome = findViewById(R.id.editTextNome);
        etDescricao = findViewById(R.id.editTextDescricao);
        etEstoque = findViewById(R.id.editTextEstoque);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);

        produto = new Produto();

        btnSalvar.setOnClickListener(view -> {
            salvar();
        });

        btnLimpar.setOnClickListener(view -> {
            etCodigo.setText("");
            etNome.setText("");
            etDescricao.setText("");
            etEstoque.setText("");
        });
    }

    private void salvar(){
        String codigo = etCodigo.getText().toString();
        String nome = etNome.getText().toString();
        String descricao = etDescricao.getText().toString();
        String estoque = etEstoque.getText().toString();

        if(!codigo.isEmpty() && !nome.isEmpty() && !descricao.isEmpty() && !estoque.isEmpty()){
            produto.setCodigo_produto(Integer.parseInt(codigo));
            produto.setNome_produto(nome);
            produto.setDescricao_produto(descricao);
            produto.setEstoque(Integer.parseInt(estoque));

            Produto.listaProdutos.add(produto);

            Toast.makeText(this, "Produto salvo com sucesso", Toast.LENGTH_LONG).show();
            finish();
        }else{
            Toast.makeText(this, "Um ou mais campos estão vazios", Toast.LENGTH_LONG).show();
        }
    }
}