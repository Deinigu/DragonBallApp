package com.example.empotradosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.empotradosapp.db.DbHelper;
import com.example.empotradosapp.personaje.Personaje;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Atributos para manejar la BD
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    private void initPersonajes() {
        // Adición de valores a la BD
        ContentValues values = new ContentValues();
        values.put("nombre","Krilin");
        values.put("bando",true);
        values.put("minPoder",3000);
        values.put("maxPoder",20000);
        values.put("tier",2);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

    }


    // Devuelve todos los personajes de la base de datos
    public List<Personaje> getAllCharacters(){
        List<Personaje> personajes = null;
        Personaje personaje = null;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + DbHelper.TABLE_PERSONAJES , null);

        do
        {
            personaje = new Personaje();
            personaje.setId(cursorPersonaje.getInt(0));
            personaje.setNombre(cursorPersonaje.getString(1));
            personaje.setBando(cursorPersonaje.getInt(2));
            personaje.setMinPoder(cursorPersonaje.getInt(3));
            personaje.setMaxPoder(cursorPersonaje.getInt(4));
            personaje.setTier(cursorPersonaje.getInt(5));

            personajes.add(personaje);
        } while(cursorPersonaje.moveToNext());

        cursorPersonaje.close();

        return personajes;
    }

    // Devuelve un personaje de la base de datos a partir de su nombre
    public Personaje buscarPersonajePorNombre(String nombre){
        Personaje personaje = null;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + DbHelper.TABLE_PERSONAJES + " WHERE nombre = '" + nombre + "' LIMIT 1;", null);

        if(cursorPersonaje.moveToFirst())
        {
                personaje = new Personaje();
                personaje.setId(cursorPersonaje.getInt(0));
                personaje.setNombre(cursorPersonaje.getString(1));
                personaje.setBando(cursorPersonaje.getInt(2));
                personaje.setMinPoder(cursorPersonaje.getInt(3));
                personaje.setMaxPoder(cursorPersonaje.getInt(4));
                personaje.setTier(cursorPersonaje.getInt(5));
        }

        cursorPersonaje.close();

        return personaje;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        TextView texto = findViewById(R.id.textView);
        initPersonajes();

        Personaje personaje = buscarPersonajePorNombre("Krilin");
        texto.setText(personaje.getNombre());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

}