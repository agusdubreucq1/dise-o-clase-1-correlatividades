package domain;

import java.util.*;

public class Materia {
    private String nombre;
    private final Set<Materia> materiasCorrelativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.materiasCorrelativas = new HashSet<>();
    }

    public Set<Materia> getMateriasCorrelativas() {
        return materiasCorrelativas;
    }

    public void addMaterias(Materia ... materias){
        Collections.addAll(this.materiasCorrelativas, materias);
    }

}
