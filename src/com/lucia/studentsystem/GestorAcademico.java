package com.lucia.studentsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Integer>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (!cursos.stream().anyMatch(c -> c.getId() == idCurso)) {
            throw new IllegalArgumentException("Curso no válido");
        }
        inscripciones.putIfAbsent(estudiante.getId(), new ArrayList<>());
        if (inscripciones.get(estudiante.getId()).contains(idCurso)) {
            throw new EstudianteYaInscritoException("Estudiante ya inscrito en este curso");
        }
        inscripciones.get(estudiante.getId()).add(idCurso);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        if (!inscripciones.containsKey(idEstudiante) || !inscripciones.get(idEstudiante).contains(idCurso)) {
            throw new EstudianteNoInscritoEnCursoException("Estudiante no inscrito en este curso o curso no válido");
        }
        inscripciones.get(idEstudiante).remove((Integer) idCurso);
    }
}
