package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AsistenteCursoTest {

    @Test
    public void testConstructorAndGetters() {
        AsistenteCurso asistenteCurso = new AsistenteCurso();
        asistenteCurso.setRbd(12345);
        asistenteCurso.setEnsenanza(1);
        asistenteCurso.setGrado(2);
        asistenteCurso.setLetra("A");

        AsistenteCurso.Asistente asistente = new AsistenteCurso.Asistente();
        asistente.setRut(12345678);
        asistente.setDv("9");

        List<AsistenteCurso.Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);

        asistenteCurso.setAsistentes(asistentes);

        assertEquals(Integer.valueOf(12345), asistenteCurso.getRbd());
        assertEquals(Integer.valueOf(1), asistenteCurso.getEnsenanza());
        assertEquals(Integer.valueOf(2), asistenteCurso.getGrado());
        assertEquals("A", asistenteCurso.getLetra());
        assertNotNull(asistenteCurso.getAsistentes());
        assertEquals(1, asistenteCurso.getAsistentes().size());
    }

    @Test
    public void testAsistenteInnerClass() {
        AsistenteCurso.Asistente asistente = new AsistenteCurso.Asistente();
        asistente.setRut(87654321);
        asistente.setDv("K");

        assertEquals(Integer.valueOf(87654321), asistente.getRut());
        assertEquals("K", asistente.getDv());
    }

    @Test
    public void testToString() {
        AsistenteCurso asistenteCurso = new AsistenteCurso();
        asistenteCurso.setRbd(12345);

        String toStringResult = asistenteCurso.toString();
        assertTrue(toStringResult.contains("rbd=12345"));
    }

    @Test
    public void testEqualsAndHashCode() {
        AsistenteCurso curso1 = new AsistenteCurso();
        curso1.setRbd(12345);

        AsistenteCurso curso2 = new AsistenteCurso();
        curso2.setRbd(12345);

        assertEquals(curso1, curso2);
        assertEquals(curso1.hashCode(), curso2.hashCode());
    }
}
