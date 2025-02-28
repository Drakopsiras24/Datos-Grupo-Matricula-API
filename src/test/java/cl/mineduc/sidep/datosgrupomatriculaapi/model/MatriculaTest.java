package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatriculaTest {

    @Test
    public void testConstructorAndGetters() {
        Matricula matricula = new Matricula();
        matricula.setRbd(12345);
        matricula.setEnsenanza(1);
        matricula.setGrado(3);
        matricula.setLetra("A");
        matricula.setJornada("MAÑANA");
        matricula.setJornadaExtendida("SI");
        matricula.setRut(12345678);
        matricula.setDv("9");
        matricula.setFechaMatricula("01-03-2025");

        assertEquals(Integer.valueOf(12345), matricula.getRbd());
        assertEquals(Integer.valueOf(1), matricula.getEnsenanza());
        assertEquals(Integer.valueOf(3), matricula.getGrado());
        assertEquals("A", matricula.getLetra());
        assertEquals("MAÑANA", matricula.getJornada());
        assertEquals("SI", matricula.getJornadaExtendida());
        assertEquals(Integer.valueOf(12345678), matricula.getRut());
        assertEquals("9", matricula.getDv());
        assertEquals("01-03-2025", matricula.getFechaMatricula());
    }

    @Test
    public void testToString() {
        Matricula matricula = new Matricula();
        matricula.setRbd(12345);

        String toStringResult = matricula.toString();
        assertTrue(toStringResult.contains("rbd=12345"));
    }

    @Test
    public void testEqualsAndHashCode() {
        Matricula mat1 = new Matricula();
        mat1.setRbd(12345);

        Matricula mat2 = new Matricula();
        mat2.setRbd(12345);

        assertEquals(mat1, mat2);
        assertEquals(mat1.hashCode(), mat2.hashCode());
    }
}
