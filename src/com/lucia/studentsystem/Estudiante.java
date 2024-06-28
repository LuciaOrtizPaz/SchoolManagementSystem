package com.lucia.studentsystem;

import java.util.Date;

public class Estudiante extends Persona {
    private String estado;

    public Estudiante(int id, String nombre, String apellido, Date fechaDeNacimiento, String estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
