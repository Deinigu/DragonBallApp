package com.example.empotradosapp.personaje;

public class Personaje {
    private int id;
    private String nombre;
    private int bando; // Bueno: 0, Malo: 1.
    private int minPoder;
    private int maxPoder;
    private int tier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int isBando() {
        return bando;
    }

    public void setBando(int bando) {
        this.bando = bando;
    }

    public int getMinPoder() {
        return minPoder;
    }

    public void setMinPoder(int minPoder) {
        this.minPoder = minPoder;
    }

    public int getMaxPoder() {
        return maxPoder;
    }

    public void setMaxPoder(int maxPoder) {
        this.maxPoder = maxPoder;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}
