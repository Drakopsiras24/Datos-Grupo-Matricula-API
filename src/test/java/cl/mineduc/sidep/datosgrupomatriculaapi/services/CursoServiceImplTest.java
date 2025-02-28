package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GrupoMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CursoServiceImplTest {

    @Mock
    private GrupoMapper grupoMapper;

    @InjectMocks
    private CursoServiceImpl cursoService;

    private GrupoModel grupoModel;

    @Before
    public void setUp() {
        grupoModel = new GrupoModel();
        grupoModel.setRbd(1);
        grupoModel.setGrado(1);
        grupoModel.setLetra("A");
        grupoModel.setJornada(1);
    }

    /**
     * Test para crear un curso
     */
    @Test
    public void crearCurso() {
        doNothing().when(grupoMapper).insertGrupo(any(GrupoModel.class));

        cursoService.crearCurso(grupoModel);

        verify(grupoMapper, times(1)).insertGrupo(any(GrupoModel.class));
    }

    /**
     * Test para actualizar un curso
     */
    @Test
    public void actualizarCurso() {
        doNothing().when(grupoMapper).updateGrupo(any(GrupoModel.class));

        cursoService.actualizarCurso(grupoModel);

        verify(grupoMapper, times(1)).updateGrupo(any(GrupoModel.class));
    }

    /**
     * Test para obtener un curso por RBD
     */
    @Test
    public void obtenerCurso() {
        when(grupoMapper.getGrupoByRBD(anyInt())).thenReturn(grupoModel);

        GrupoModel result = cursoService.obtenerCurso(1);

        assertNotNull(result);
        assertEquals(Integer.valueOf(1), result.getRbd());
        verify(grupoMapper, times(1)).getGrupoByRBD(anyInt());
    }

    /**
     * Test para eliminar un curso
     */
    @Test
    public void eliminarCurso() {
        when(grupoMapper.deleteGrupo(anyInt())).thenReturn(1);

        boolean eliminado = cursoService.eliminarCurso(1);

        assertTrue(eliminado);
        verify(grupoMapper, times(1)).deleteGrupo(anyInt());
    }

    /**
     * Test para obtener un curso con parámetros específicos
     */
    @Test
    public void obtenerCursoConParametros() {
        when(grupoMapper.getGrupoByParametros(anyInt(), anyInt(), anyString())).thenReturn(grupoModel);

        GrupoModel result = cursoService.obtenerCursoConParametros(1, 1, "A");

        assertNotNull(result);
        assertEquals(Integer.valueOf(1), result.getRbd());
        verify(grupoMapper, times(1)).getGrupoByParametros(anyInt(), anyInt(), anyString());
    }

    /**
     * Test para obtener ID por RBD (cuando se encuentra el curso)
     */
    @Test
    public void obtenerIdPorRbd_Encontrado() {
        when(grupoMapper.getGrupoByRBD(anyInt())).thenReturn(grupoModel);

        Integer id = cursoService.obtenerIdPorRbd(1);

        assertNotNull(id);
        assertEquals(Integer.valueOf(1), id);
    }

    /**
     * Test para obtener ID por RBD (cuando NO se encuentra el curso)
     */
    @Test(expected = RuntimeException.class)
    public void obtenerIdPorRbd_NoEncontrado() {
        when(grupoMapper.getGrupoByRBD(anyInt())).thenReturn(null);

        cursoService.obtenerIdPorRbd(999);
    }
}
