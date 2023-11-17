package com.jardeu.imdmarket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        btnVoltar = findViewById(R.id.btnVoltar);

        ProductsAdapter adapter = new ProductsAdapter(this, Produto.listaProdutos);

        ListView lvProdutos = findViewById(R.id.listViewListaProdutos);

        lvProdutos.setAdapter(adapter);

        lvProdutos.setOnItemClickListener((adapterView, view, position, id) -> {
            Produto item = (Produto) adapterView.getItemAtPosition(position);

            AlertDialog.Builder builder = new AlertDialog.Builder(ListarActivity.this);
            builder.setTitle("Informações adicionais");
            builder.setMessage("Código: " + item.getCodigo_produto() +
                    "\nNome: " + item.getNome_produto() +
                    "\nDescrição: " + item.getDescricao_produto() +
                    "\nEstoque: " + item.getEstoque());

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });

            builder.show();
        });

        btnVoltar.setOnClickListener(view -> {
            finish();
        });
    }
}