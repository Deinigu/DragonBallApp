package com.example.empotradosapp;

public class Personaje {
    private int id;
    private String nombre;
    private int bando;
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
