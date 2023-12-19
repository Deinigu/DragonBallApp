package com.example.empotradosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.empotradosapp.db.DbHelper;
import com.example.empotradosapp.personaje.Personaje;
import com.example.empotradosapp.personaje.PersonajeContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Atributos para manejar la BD
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    // Atributos para views
    private Spinner dropMenu;
    private TextView villainText;

    private void initPersonajes() {

        // Reiniciar la base de datos si existe
        dbHelper.restartDBIfExists(db);

        // Adición de valores a la BD
        ContentValues values = new ContentValues();

        // Krilin
        values.put("nombre", "Krilin");
        values.put("bando", 0);
        values.put("minPoder", 3);
        values.put("maxPoder", 20);
        values.put("tier", 2);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Goku
        values.put("nombre", "Goku");
        values.put("bando", 0);
        values.put("minPoder", 30);
        values.put("maxPoder", 150);
        values.put("tier", 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Vegeta
        values.put("nombre", "Vegeta");
        values.put("bando", 0);
        values.put("minPoder", 28);
        values.put("maxPoder", 80);
        values.put("tier", 4);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Gohan
        values.put("nombre", "Gohan");
        values.put("bando", 0);
        values.put("minPoder", 25);
        values.put("maxPoder", 145);
        values.put("tier", 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Gogeta
        values.put("nombre", "Gogeta");
        values.put("bando", 0);
        values.put("minPoder", 50);
        values.put("maxPoder", 250);
        values.put("tier", 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Mr. Satan
        values.put("nombre", "Mr. Satan");
        values.put("bando", 0);
        values.put("minPoder", 1);
        values.put("maxPoder", 25);
        values.put("tier", 1);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Raditz
        values.put("nombre", "Raditz");
        values.put("bando", 1);
        values.put("minPoder", 15);
        values.put("maxPoder", 30);
        values.put("tier", 1);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Freezer
        values.put("nombre", "Freezer");
        values.put("bando", 1);
        values.put("minPoder", 30);
        values.put("maxPoder", 150);
        values.put("tier", 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Capitán Ginyu
        values.put("nombre", "Capitán Ginyu");
        values.put("bando", 1);
        values.put("minPoder", 20);
        values.put("maxPoder", 75);
        values.put("tier", 3);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Majin Buu
        values.put("nombre", "Majin Buu");
        values.put("bando", 1);
        values.put("minPoder", 25);
        values.put("maxPoder", 145);
        values.put("tier", 4);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Cell
        values.put("nombre", "Cell");
        values.put("bando", 1);
        values.put("minPoder", 50);
        values.put("maxPoder", 150);
        values.put("tier", 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);
    }

    // Devuelve todos los personajes de la base de datos
    public List<Personaje> getAllCharacters() {
        List<Personaje> personajes = new ArrayList<>();
        Personaje personaje = null;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + DbHelper.TABLE_PERSONAJES + ";", null);
        if (cursorPersonaje.moveToFirst()) {
            do {
                personaje = new Personaje();
                personaje.setId(cursorPersonaje.getInt(0));
                personaje.setNombre(cursorPersonaje.getString(1));
                personaje.setBando(cursorPersonaje.getInt(2));
                personaje.setMinPoder(cursorPersonaje.getInt(3));
                personaje.setMaxPoder(cursorPersonaje.getInt(4));
                personaje.setTier(cursorPersonaje.getInt(5));

                personajes.add(personaje);
            } while (cursorPersonaje.moveToNext());
        }

        cursorPersonaje.close();

        return personajes;
    }

    // Devuelve una lista de personajes según su bando 0: Buenos, 1: Malos
    public List<Personaje> findCharactersByBando(int bando) {
        List<Personaje> personajes = new ArrayList<>();
        Personaje personaje = null;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + DbHelper.TABLE_PERSONAJES + " WHERE " +  PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO + " = " + bando + ";", null);
        if (cursorPersonaje.moveToFirst()) {
            do {
                personaje = new Personaje();
                personaje.setId(cursorPersonaje.getInt(0));
                personaje.setNombre(cursorPersonaje.getString(1));
                personaje.setBando(cursorPersonaje.getInt(2));
                personaje.setMinPoder(cursorPersonaje.getInt(3));
                personaje.setMaxPoder(cursorPersonaje.getInt(4));
                personaje.setTier(cursorPersonaje.getInt(5));

                personajes.add(personaje);
            } while (cursorPersonaje.moveToNext());
        }

        cursorPersonaje.close();

        return personajes;
    }

    // Devuelve un personaje de la base de datos a partir de su nombre
    public Personaje findPersonajeByNombre(String nombre) {
        Personaje personaje = null;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + DbHelper.TABLE_PERSONAJES + " WHERE " +  PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE + " = '" + nombre + "' LIMIT 1;", null);

        if (cursorPersonaje.moveToFirst()) {
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

        // Obtener views
        dropMenu = findViewById(R.id.dropMenu);
        villainText = findViewById(R.id.villainText);

        // Inicializar base de datos
        dbHelper = new DbHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        // Poblar base de datos
        initPersonajes();

        // Buscar personaje malvado aleatorio
        List<Personaje> personajesMalos = findCharactersByBando(1);
        Random random = new Random();
        Personaje villano = personajesMalos.get(random.nextInt(personajesMalos.size()));
        villainText.setText(villano.getNombre());


        // Lista de nombres personajes buenos en dropMenu
        List<Personaje> personajesBuenos = findCharactersByBando(0);
        List<String> personajesNames = new ArrayList<>();

        for (Personaje p : personajesBuenos) {
            personajesNames.add(p.getNombre());
        }

        // Esto es para añadir los nombres al desplegable
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, personajesNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropMenu.setAdapter(adapter);
    }

    // Cuando se pulsa el boton se envian los datos a la otra actividad
    public void onClickLuchar(View view){
        try{
            String nombre = dropMenu.getSelectedItem().toString();


            //Log.i("Prueba", heroe.getNombre() + "    " + villano.getNombre());
            Intent intent = new Intent(this, ResultadoActivity.class);
            Bundle n = new Bundle();
            n.putString("heroe",nombre);
            n.putString("villano",villainText.getText().toString());
            intent.putExtras(n);
            startActivity(intent);
        } catch (Exception e){
            Log.e("Error", "No se recogieron bien los nombres");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

}