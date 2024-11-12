package com.example.appcertamen5;

public class Nota {
    private String titulo;
    private String contenido;

    //Constructor

    public Nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }
}
