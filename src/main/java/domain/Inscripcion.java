package domain;

import java.util.*;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasSolicitadas;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasSolicitadas = new HashSet<>();
    }

    public void addMaterias(Materia ... materias){
        Collections.addAll(this.materiasSolicitadas, materias);
    }

    public boolean aprobada(){
       return this.materiasSolicitadas.stream().allMatch(m -> this.alumno.puedeCursar(m));
    }
}
