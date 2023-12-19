package com.example.empotradosapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.empotradosapp.personaje.PersonajeContract;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1; // Versión de la Base de Datos
    private static final String DATABASE_NAME = "dragonball.db"; // Nombre de la base de datos
    public static final String TABLE_PERSONAJES = PersonajeContract.PersonajeEntry.TABLE_NAME; // Nombre de la tabla

    // Query para la creación de la tabla de personajes
    public static final String SQL_CREATE_PERSONAJES = "CREATE TABLE " + TABLE_PERSONAJES + "(" +
            PersonajeContract.PersonajeEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            PersonajeContract.PersonajeEntry.COLUMN_NAME_NOMBRE + " TEXT NOT NULL," +
            PersonajeContract.PersonajeEntry.COLUMN_NAME_BANDO + " INTEGER NOT NULL," +
            PersonajeContract.PersonajeEntry.COLUMN_NAME_MINPODER + " INTEGER NOT NULL," +
            PersonajeContract.PersonajeEntry.COLUMN_NAME_MAXPODER + " INTEGER NOT NULL," +
            PersonajeContract.PersonajeEntry.COLUMN_NAME_TIER + " INTEGER NOT NULL)";
    // Query para la eliminación de la tabla de personajes
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_PERSONAJES;

    public DbHelper(@Nullable Context context) {
        // Constructor de la base de datos
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void restartDBIfExists(SQLiteDatabase db)
    {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_CREATE_PERSONAJES);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Este método será invocado al establecer la conexión con la BD
        // en el caso de que la creación de la BD sea necesaria
        db.execSQL(SQL_CREATE_PERSONAJES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Este método será invocado al establecer la conexión con la BD
        // en el caso de que la versión de la BD almacenada sea inferior a
        // la versión de la BD que queremos abrir (especificada por
        // DATABASE_VERSION proporcionada en el constructor de la clase)
        //
        // Una política de actualización simple: eliminar los datos almacenados
        // y comenzar de nuevo con una BD vacía
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Este método será invocado al establecer la conexión con la BD
        // en el caso de que la versión de la BD almacenada sea superior a
        // la versión de la BD que queremos abrir (especificada por
        // DATABASE_VERSION proporcionada en el constructor de la clase)
        //
        // Una política de actualización simple: eliminar los datos almacenados
        // y comenzar de nuevo con una BD vacía
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }


}
