package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.MatriculaMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Matricula;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class MatriculaServiceImplTest {

    @Mock
    private MatriculaMapper matriculaMapper;

    @InjectMocks
    private MatriculaServiceImpl matriculaService;

    @Before
    public void setUp() {
        matriculaService = new MatriculaServiceImpl(matriculaMapper);
    }

    /**
     * Test para ingresar una matrícula
     */
    @Test
    public void ingresarMatricula() {
        Matricula matricula = new Matricula();
        matricula.setRbd(12345);
        matricula.setRut(12345678);
        matricula.setDv("9");
        matricula.setGrado(1);
        matricula.setLetra("A");
        matricula.setJornada("MAÑANA");

        doNothing().when(matriculaMapper).insertMatricula(any(Matricula.class));

        matriculaService.ingresarMatricula(matricula);

        verify(matriculaMapper, times(1)).insertMatricula(any(Matricula.class));
    }

    /**
     * Test para actualizar una matrícula
     */
    @Test
    public void actualizarMatricula() {
        Matricula matricula = new Matricula();
        matricula.setRbd(12345);
        matricula.setRut(12345678);
        matricula.setDv("9");
        matricula.setGrado(2);
        matricula.setLetra("B");
        matricula.setJornada("TARDE");

        doNothing().when(matriculaMapper).updateMatricula(any(Matricula.class));

        matriculaService.actualizarMatricula(matricula);

        verify(matriculaMapper, times(1)).updateMatricula(any(Matricula.class));
    }

    /**
     * Test para obtener matrículas por RBD y Rut
     */
    @Test
    public void obtenerMatriculasPorRbdYRut() {
        List<Matricula> listaMatriculas = new ArrayList<>();
        Matricula matricula = new Matricula();
        matricula.setRbd(12345);
        matricula.setRut(12345678);
        matricula.setDv("9");
        matricula.setGrado(3);
        matricula.setLetra("C");
        matricula.setJornada("MAÑANA");
        listaMatriculas.add(matricula);

        when(matriculaMapper.getMatriculasByRbdAndRut(12345, 12345678)).thenReturn(listaMatriculas);

        List<Matricula> resultado = matriculaService.obtenerMatriculasPorRbdYRut(12345, 12345678);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals(Integer.valueOf(12345), resultado.get(0).getRbd());
        assertEquals(Integer.valueOf(12345678), resultado.get(0).getRut());
        assertEquals("9", resultado.get(0).getDv());
        assertEquals(Integer.valueOf(3), resultado.get(0).getGrado());
        assertEquals("C", resultado.get(0).getLetra());
        assertEquals("MAÑANA", resultado.get(0).getJornada());

        verify(matriculaMapper, times(1)).getMatriculasByRbdAndRut(12345, 12345678);
    }

    /**
     * Test para eliminar una matrícula
     */
    @Test
    public void eliminarMatricula() {
        when(matriculaMapper.deleteMatricula(12345, 12345678)).thenReturn(1);

        boolean resultado = matriculaService.eliminarMatricula(12345, 12345678);

        assertTrue(resultado);

        verify(matriculaMapper, times(1)).deleteMatricula(12345, 12345678);
    }

    /**
     * Test para eliminar una matrícula que no existe
     */
    @Test
    public void eliminarMatricula_CuandoNoExiste() {
        when(matriculaMapper.deleteMatricula(12345, 99999999)).thenReturn(0);

        boolean resultado = matriculaService.eliminarMatricula(12345, 99999999);

        assertFalse(resultado);

        verify(matriculaMapper, times(1)).deleteMatricula(12345, 99999999);
    }
}
