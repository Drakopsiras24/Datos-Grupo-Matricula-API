package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrupoModelTest {

    @Test
    public void testConstructorAndGetters() {
        GrupoModel grupoModel = new GrupoModel();
        grupoModel.setRbd(12345);
        grupoModel.setGrado(2);
        grupoModel.setLetra("B");
        grupoModel.setJornada(1);
        grupoModel.setCupo(30);

        GrupoModel.Educador educador = new GrupoModel.Educador();
        educador.setRut(98765432);
        educador.setDv("K");
        grupoModel.setEducador(educador);

        assertEquals(Integer.valueOf(12345), grupoModel.getRbd());
        assertEquals(Integer.valueOf(2), grupoModel.getGrado());
        assertEquals("B", grupoModel.getLetra());
        assertEquals(Integer.valueOf(1), grupoModel.getJornada());
        assertEquals(Integer.valueOf(30), grupoModel.getCupo());
        assertNotNull(grupoModel.getEducador());
        assertEquals(Integer.valueOf(98765432), grupoModel.getEducador().getRut());
        assertEquals("K", grupoModel.getEducador().getDv());
    }

    @Test
    public void testToString() {
        GrupoModel grupoModel = new GrupoModel();
        grupoModel.setRbd(12345);

        String toStringResult = grupoModel.toString();
        assertTrue(toStringResult.contains("rbd=12345"));
    }

    @Test
    public void testEqualsAndHashCode() {
        GrupoModel grupo1 = new GrupoModel();
        grupo1.setRbd(12345);

        GrupoModel grupo2 = new GrupoModel();
        grupo2.setRbd(12345);

        assertEquals(grupo1, grupo2);
        assertEquals(grupo1.hashCode(), grupo2.hashCode());
    }
}
