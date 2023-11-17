package com.jardeu.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;

public class DeletarActivity extends AppCompatActivity {
    EditText etCodigo;
    Button btnDeletar, btnLimpar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        etCodigo = findViewById(R.id.editTextCodigo3);

        btnDeletar = findViewById(R.id.btnDeletarProduto);
        btnLimpar = findViewById(R.id.btnLimpar4);

        btnDeletar.setOnClickListener(view -> {
            String codigo = etCodigo.getText().toString();
            if (!codigo.isEmpty()) {
                Iterator<Produto> it = Produto.listaProdutos.iterator();

                while(it.hasNext()){
                    Produto p = it.next();
                    if (p.getCodigo_produto() == Integer.parseInt(codigo)) {
                        it.remove();
                        Toast.makeText(this, "Produto deletado com sucesso", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            } else {
                Toast.makeText(this, "Digite o código do produto", Toast.LENGTH_LONG).show();
            }
        });
    }
}