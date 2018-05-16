package com.meag.sqllabo7.Datos;

/**
 * Created by uca on 05-16-18.
 */

public class Persona {
    private String dui, nombre;

    public Persona(String dui, String nombre) {
        this.dui = dui;
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
