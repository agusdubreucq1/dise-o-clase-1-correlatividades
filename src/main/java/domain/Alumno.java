package domain;

import java.util.*;

public class Alumno {
    private String nombre;
    private Set<Materia> materiasAprob;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprob = new HashSet<>();
    }

    public Set<Materia> getMateriasAprob() {
        return materiasAprob;
    }

    public void addMaterias(Materia ... materias){
        Collections.addAll(this.materiasAprob, materias);
    }

    public boolean puedeCursar(Materia materia){
        return this.materiasAprob.containsAll(materia.getMateriasCorrelativas());
    }


}
