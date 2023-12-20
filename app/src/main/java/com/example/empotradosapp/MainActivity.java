package com.example.empotradosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    private TextView minPowerText;
    private TextView maxPowerText;

    private void initPersonajes() {

        // Reiniciar la base de datos si existe
        dbHelper.restartDBIfExists(db);

        // Adición de valores a la BD
        ContentValues values = new ContentValues();

        // Krilin
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Krilin");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 0);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 3);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 20);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 2);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Goku
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Goku");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 0);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 30);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 150);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Vegeta
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Vegeta");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 0);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 28);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 80);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 4);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Gohan
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Gohan");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 0);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 25);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 145);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Gogeta
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Gogeta");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 0);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 50);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 250);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Mr. Satan
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Mr. Satan");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 0);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 1);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 25);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 1);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Raditz
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Raditz");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 1);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 15);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 30);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 1);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Freezer
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Freezer");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 1);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 30);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 150);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 5);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Dabra
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Dabra");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 1);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 20);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 75);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 3);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Majin Buu
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Majin Buu");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 1);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 25);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 145);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 4);
        db.insert(DbHelper.TABLE_PERSONAJES, null, values);

        // Cell
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE, "Cell");
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO, 1);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER, 50);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER, 150);
        values.put(PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER, 5);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener views
        dropMenu = findViewById(R.id.dropMenu);
        villainText = findViewById(R.id.villainText);
        minPowerText = findViewById(R.id.minPower);
        maxPowerText = findViewById(R.id.maxPower);


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

        dropMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                minPowerText.setText(String.valueOf(personajesBuenos.get(position).getMinPoder()));
                maxPowerText.setText(String.valueOf(personajesBuenos.get(position).getMaxPoder()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                minPowerText.setText(String.valueOf(personajesBuenos.get(0).getMinPoder()));
                maxPowerText.setText(String.valueOf(personajesBuenos.get(0).getMaxPoder()));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Personaje> personajesMalos = findCharactersByBando(1);
        Random random = new Random();
        Personaje villano = personajesMalos.get(random.nextInt(personajesMalos.size()));
        villainText.setText(villano.getNombre());
    }

    // Cuando se pulsa el boton se envian los datos a la otra actividad
    public void onClickLuchar(View view){
        try{
            String nombre = dropMenu.getSelectedItem().toString();

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