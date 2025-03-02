package cl.mineduc.sidep.datosgrupomatriculaapi.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatriculaUnidadEducativaEntityTest {

    @Test
    public void equals() {
        assertEquals(new MatriculaUnidadEducativaEntity(), new MatriculaUnidadEducativaEntity());
    }

    @Test
    public void notEquals() {
        MatriculaUnidadEducativaEntity p1 = new MatriculaUnidadEducativaEntity();
        MatriculaUnidadEducativaEntity p2 = new MatriculaUnidadEducativaEntity();
        p1.setId(1L);
        p2.setId(2L);

        assertNotEquals(p1, p2);

    }

    @Test
    public void testHashCode() {
        MatriculaUnidadEducativaEntity p1 = new MatriculaUnidadEducativaEntity();
        MatriculaUnidadEducativaEntity p2 = new MatriculaUnidadEducativaEntity();

        assertEquals(p1.hashCode(), p2.hashCode());

    }

    @Test
    public void tesToString() {
        MatriculaUnidadEducativaEntity p1 = new MatriculaUnidadEducativaEntity();
        String expected = "";
        assertNotEquals(expected, p1.toString());
    }


}