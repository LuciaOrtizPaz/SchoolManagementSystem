package com.lucia.studentsystem;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", new Date(), "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "María", "González", new Date(), "matriculado");

        System.out.println("Estudiante " + estudiante1.getNombre() + " " + estudiante1.getApellido() + " matriculado.");
        System.out.println("Estudiante " + estudiante2.getNombre() + " " + estudiante2.getApellido() + " matriculado.");

        Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas básicas", 3, "1.0");
        Curso curso2 = new Curso(2, "Historia", "Curso de historia universal", 4, "1.0");

        GestorAcademico gestor = new GestorAcademico();

        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        System.out.println("Curso " + curso1.getNombre() + " agregado.");
        System.out.println("Curso " + curso2.getNombre() + " agregado.");

        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        try {
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            System.out.println("Estudiante " + estudiante1.getNombre() + " " + estudiante1.getApellido() + " inscrito en el curso " + curso1.getNombre() + ".");
            gestor.inscribirEstudianteCurso(estudiante2, curso2.getId());
            System.out.println("Estudiante " + estudiante2.getNombre() + " " + estudiante2.getApellido() + " inscrito en el curso " + curso2.getNombre() + ".");
        } catch (EstudianteYaInscritoException e) {
            e.printStackTrace();
        }

        try {
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
            System.out.println("Estudiante " + estudiante1.getNombre() + " " + estudiante1.getApellido() + " desinscrito del curso " + curso1.getNombre() + ".");
        } catch (EstudianteNoInscritoEnCursoException e) {
            e.printStackTrace();
        }
    }
}
