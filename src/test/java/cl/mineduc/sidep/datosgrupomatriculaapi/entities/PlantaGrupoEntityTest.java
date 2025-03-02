package cl.mineduc.sidep.datosgrupomatriculaapi.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlantaGrupoEntityTest {

    @Test
    public void equals() {
        assertEquals(new PlantaGrupoEntity(), new PlantaGrupoEntity());
    }

    @Test
    public void notEquals() {
        PlantaGrupoEntity p1 = new PlantaGrupoEntity();
        PlantaGrupoEntity p2 = new PlantaGrupoEntity();
        p1.setId(1L);
        p2.setId(2L);

        assertNotEquals(p1, p2);

    }

    @Test
    public void testHashCode() {
        PlantaGrupoEntity p1 = new PlantaGrupoEntity();
        PlantaGrupoEntity p2 = new PlantaGrupoEntity();

        assertEquals(p1.hashCode(), p2.hashCode());

    }

    @Test
    public void tesToString() {
        PlantaGrupoEntity p1 = new PlantaGrupoEntity();
        String expected = "";
        assertNotEquals(expected, p1.toString());
    }



}