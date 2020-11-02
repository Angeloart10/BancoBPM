package com.example.bancobpm;

import Clases.AdminSQLiteOpenHelper;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Clientes_act extends AppCompatActivity {

    private EditText edcod, ednom, edpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);
        edcod = (EditText) findViewById(R.id.edit_cod);
        ednom = (EditText) findViewById(R.id.edit_nombre);
        edpre = (EditText) findViewById(R.id.edit_precio);

    }

    public void Añadirinsumos(View V) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Clientes", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        if (!edcod.getText().toString().isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("codigo", edcod.getText().toString());
            registro.put("nombre", ednom.getText().toString());
            registro.put("Salario", edpre.getText().toString());


            db.insert("insumo", "null", registro);
            db.close();
            Toast.makeText(this, "se ha guardado el cliente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "debe rellenar los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void MostrarI(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Clientes",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edcod.getText().toString();
        if(!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT nombre, salario, stock FROM clientes WHERE codigo="+ codigo,null);
            if(fila.moveToFirst()) {


                ednom.setText(fila.getString(0));
                edpre.setText(fila.getString(1));

            }
        }else{
            Toast.makeText(this,"no hay cliente asociado al codigo", Toast.LENGTH_LONG).show();
        }
    }
    public void EliinarInsumos(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Clientes",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String  codigo = edcod.getText().toString();
        db.delete("Clientes", "codigo="+codigo, null);
        db.close();
        Toast.makeText(this,"Has eliminado un cliente", Toast.LENGTH_LONG).show();

    }
    public void ActualizarInsumos(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Clientes",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String  codigo = edcod.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", edcod.getText().toString());
        cont.put("nombre", ednom.getText().toString());
        cont.put("salario", edpre.getText().toString());


        if(!codigo.isEmpty()){
            db.update("insumo",cont,"codigo="+codigo,null);

            Toast.makeText(this,"has actualizado un campo",Toast.LENGTH_LONG).show();
        }
    }
}