import domain.Alumno;
import domain.Materia;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestALumno {

    private Alumno alumnoSinMaterias;
    private Alumno alumnoConMaterias;
    private Materia materiaSinCorrelativas;
    private Materia materiaConCorrelativas;
    @Before
    public void init(){
        this.alumnoSinMaterias = new Alumno("agustin");
        this.alumnoConMaterias = new Alumno("lucas");

        this.materiaSinCorrelativas = new Materia("algoritmos");
        this.materiaConCorrelativas = new Materia("analisis de sistemas");
        this.materiaConCorrelativas.addMaterias(this.materiaSinCorrelativas);

        this.alumnoConMaterias.addMaterias(this.materiaSinCorrelativas);
    }


    @Test
    public void añadeMaterias(){
        this.alumnoSinMaterias.addMaterias(this.materiaSinCorrelativas);

        Assert.assertEquals(true, this.alumnoSinMaterias.getMateriasAprob().contains(this.materiaSinCorrelativas));
    }

    @Test
    public void puedeCursarMateriaSinCorrelativas(){
        Assert.assertEquals(true, this.alumnoSinMaterias.puedeCursar(this.materiaSinCorrelativas));
    }

    @Test
    public void noPuedeCursarMateriaConCorrelativas(){
        Assert.assertEquals(false, this.alumnoSinMaterias.puedeCursar(this.materiaConCorrelativas));
    }

    @Test
    public void puedeCursarMateriaConCorrelativas(){
        Assert.assertEquals(true, this.alumnoConMaterias.puedeCursar(this.materiaConCorrelativas));
    }

}
