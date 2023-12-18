package com.example.empotradosapp.personaje;

import android.provider.BaseColumns;

public final class PersonajeContract {
    private PersonajeContract() {}

    public static abstract class PersonajeEntry implements BaseColumns {
        public static final String TABLE_NAME = "t_personajes";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_BANDO = "bando";
        public static final String COLUMN_NAME_MINPODER = "minPoder";
        public static final String COLUMN_NAME_MAXPODER = "maxPoder";
        public static final String COLUMN_NAME_TIER = "tier";


    }
}
