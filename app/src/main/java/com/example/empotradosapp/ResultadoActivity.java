package com.example.empotradosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.empotradosapp.db.DbHelper;
import com.example.empotradosapp.personaje.Personaje;
import com.example.empotradosapp.personaje.PersonajeContract;

import java.util.Random;

public class ResultadoActivity extends AppCompatActivity {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    // Views
    TextView heroName;
    TextView villainName;
    TextView heroPower;
    TextView villainPower;
    TextView resultadoText;

    // Atributos para el juego
    private int poderHeroe;
    private int poderVillano;
    private int resultado;

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
        setContentView(R.layout.activity_resultado);

        // Inicializar base de datos
        dbHelper = new DbHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        // Obtener views
        heroName = findViewById(R.id.heroName);
        heroPower = findViewById(R.id.heroPower);
        villainName = findViewById(R.id.villainName);
        villainPower = findViewById(R.id.villainPower);
        resultadoText = findViewById(R.id.resultadoText);

        // Obtenemos las variables enviadas desde la anterior actividad
        Intent t = getIntent();
        Bundle b = t.getExtras();

        String nombreHeroe = b.getString("heroe");
        String nombreVillano = b.getString("villano");

        // Buscamos a los personajes de la pelea
        Personaje heroe = findPersonajeByNombre(nombreHeroe);
        Personaje villano = findPersonajeByNombre(nombreVillano);

        // Calculamos resultado de la pelea
        resultado = calcularResultado(heroe,villano);

        // Comprobar quién ha ganado y mostrar resultado
        resultadoText.setText(getResources().getString(R.string.victory));

        if(resultado > 0)
        {
            resultadoText.setText(getResources().getString(R.string.victory));
        }
        else if(resultado == 0)
        {
            resultadoText.setText(getResources().getString(R.string.draw));
        }
        else{
            resultadoText.setText(getResources().getString(R.string.defeat));
        }

        // Poner en pantalla los nombres y el poder de cada uno
        heroName.setText(nombreHeroe);
        heroPower.setText(String.valueOf(poderHeroe));

        villainName.setText(nombreVillano);
        villainPower.setText(String.valueOf(poderVillano));


    }

    // Función que calcula el resultado de la pelea
    private int calcularResultado(Personaje heroe, Personaje villano){
        Random rand = new Random();
        poderHeroe = rand.nextInt((heroe.getMaxPoder() - heroe.getMinPoder()) + 1) + heroe.getMinPoder();
        poderVillano = rand.nextInt((villano.getMaxPoder() - villano.getMinPoder()) + 1) + villano.getMinPoder();

        return (poderHeroe - poderVillano);

    }
}