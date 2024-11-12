package com.example.appcertamen5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText titulo, cuerpo, eliminarNota;
    ListView listView;
    ArrayList<Nota> notas = new ArrayList<>();
    //Listas
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = findViewById(R.id.txtTitulo);
        cuerpo = findViewById(R.id.txtCuerpo);
        listView = findViewById(R.id.listVieww);

        //Implementaciones de listas y adapter
        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,itemList);
        listView.setAdapter(adapter);

        visualizarDatos();

    }

    public void agregarNota(View view){

        String txtTitulo = titulo.getText().toString();
        String txtCuerpo = cuerpo.getText().toString();
        
        if(!txtTitulo.isEmpty() && !txtCuerpo.isEmpty()){
            Nota nota1 = new Nota(txtTitulo, txtCuerpo);
            notas.add(nota1);
            //Actualizamos el list view
            adapter.notifyDataSetChanged();
            visualizarDatos();

            Toast.makeText(this, "Nota agregada con éxito!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Favor, no dejar campos vacíos!", Toast.LENGTH_SHORT).show();
        }
    }


    public void visualizarDatos(){
        itemList.clear();

        for(int i = 0; i < notas.size(); i++){
            Nota notas2 = notas.get(i);

            String datos = "Título: " + notas2.getTitulo() + "\nContenido: " + notas2.getContenido();
             itemList.add(datos);
        }
        //Actualizamos el list view
        adapter.notifyDataSetChanged();
    }


    public void eliminarNota(View view){

    }
}