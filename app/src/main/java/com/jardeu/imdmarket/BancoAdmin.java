package com.jardeu.imdmarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoAdmin extends SQLiteOpenHelper {
    public BancoAdmin(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {
        banco.execSQL("CREATE TABLE produtos(codigo INT UNIQUE PRIMARY KEY, nome TEXT, descricao TEXT, estoque INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int i, int i1) {

    }

    public static void lerDadosBanco(SQLiteDatabase banco) {
        try (Cursor consulta = banco.rawQuery("SELECT * FROM produtos", null)) {
            if (consulta != null && consulta.moveToFirst()) {
                do {
                    Produto p = new Produto();
                    p.setCodigo_produto(Integer.parseInt(consulta.getString(0)));
                    p.setNome_produto(consulta.getString(1));
                    p.setDescricao_produto(consulta.getString(2));
                    p.setEstoque(Integer.parseInt(consulta.getString(3)));

                    Produto.listaProdutos.add(p);
                } while (consulta.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (banco != null) {
                banco.close();
            }
        }
    }

    public static void salvarDadosBanco(SQLiteDatabase banco) {
        try {
            banco.delete("produtos", null, null);

            for (Produto item : Produto.listaProdutos) {
                ContentValues registro = new ContentValues();
                registro.put("codigo", item.getCodigo_produto());
                registro.put("nome", item.getNome_produto());
                registro.put("descricao", item.getDescricao_produto());
                registro.put("estoque", item.getEstoque());

                banco.insert("produtos", null, registro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (banco != null) {
                banco.close();
            }
        }
    }
}
