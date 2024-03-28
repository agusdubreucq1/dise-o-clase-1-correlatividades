import domain.Alumno;
import domain.Inscripcion;
import domain.Materia;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestInscripcion {
    private Inscripcion inscripcion;
    private Alumno alumno;
    private Materia materiaSinCorrelativas;

    @Before
    public void init(){
        this.alumno = new Alumno("agustin");
        this.inscripcion = new Inscripcion(this.alumno);
        this.materiaSinCorrelativas = new Materia("algoritmos");
    }

    @Test
    public void inscripcionSinCorrelativas(){
        Assert.assertTrue(this.inscripcion.aprobada());
    }

    @Test
    public void desapruebaInscripcionConCorrelativas(){
        Materia materiaConCorrelativas = new Materia("analisis 2");
        materiaConCorrelativas.addMaterias(this.materiaSinCorrelativas);

        this.inscripcion.addMaterias(materiaConCorrelativas);

        Assert.assertFalse(this.inscripcion.aprobada());
    }

    @Test
    public void necesitaTodasLasCorrelativas(){
        Materia otraMateriaSinCorrelativas = new Materia("discreta");
        Materia materiaConCorrelativas = new Materia("paradigmas");
        materiaConCorrelativas.addMaterias(this.materiaSinCorrelativas, otraMateriaSinCorrelativas);

        this.alumno.addMaterias(this.materiaSinCorrelativas);

        this.inscripcion.addMaterias(materiaConCorrelativas);

        Assert.assertFalse(this.inscripcion.aprobada());
    }

    @Test
    public void tieneTodasLasCorrelativas(){
        Materia otraMateriaSinCorrelativas = new Materia("discreta");
        Materia materiaConCorrelativas = new Materia("paradigmas");
        materiaConCorrelativas.addMaterias(this.materiaSinCorrelativas, otraMateriaSinCorrelativas);

        this.alumno.addMaterias(this.materiaSinCorrelativas, otraMateriaSinCorrelativas);

        this.inscripcion.addMaterias(materiaConCorrelativas);

        Assert.assertTrue(this.inscripcion.aprobada());
    }

    @Test
    public void necesitaCumplirConTodasLasMaterias(){
        Materia otraMateriaSinCorrelativas = new Materia("discreta");
        Materia materiaConCorrelativas = new Materia("paradigmas");
        materiaConCorrelativas.addMaterias(this.materiaSinCorrelativas, otraMateriaSinCorrelativas);

        this.alumno.addMaterias(this.materiaSinCorrelativas);

        this.inscripcion.addMaterias(materiaConCorrelativas, otraMateriaSinCorrelativas);

        Assert.assertFalse(this.inscripcion.aprobada());
    }
}
