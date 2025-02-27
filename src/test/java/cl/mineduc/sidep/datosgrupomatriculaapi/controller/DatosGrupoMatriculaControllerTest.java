package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.CursoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DatosGrupoMatriculaControllerTest {

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private DatosGrupoMatriculaController datosGrupoMatriculaController;

    private HttpServletRequest request;

    @Before
    public void setUp() {
        this.request = mock(HttpServletRequest.class);
        when(request.getMethod()).thenReturn("POST");
        when(request.getRequestURI()).thenReturn("URI");
    }

    @Test
    public void crearCurso() {
        GrupoModel curso = new GrupoModel();
        curso.setRbd(1);
        curso.setGrado(1);
        curso.setLetra("A");
        curso.setJornada(1);

        doNothing().when(cursoService).crearCurso(any(GrupoModel.class));

        ResponseEntity<Void> response = datosGrupoMatriculaController.crearCurso(curso);

        assertNotNull(response);
        verify(cursoService, times(1)).crearCurso(any(GrupoModel.class));
    }

    @Test
    public void actualizarCurso() {
        GrupoModel curso = new GrupoModel();
        curso.setRbd(1);
        curso.setGrado(1);
        curso.setLetra("A");
        curso.setJornada(1);

        doNothing().when(cursoService).actualizarCurso(any(GrupoModel.class));

        ResponseEntity<Void> response = datosGrupoMatriculaController.actualizarCurso(curso);

        assertNotNull(response);
        verify(cursoService, times(1)).actualizarCurso(any(GrupoModel.class));
    }

    @Test
    public void obtenerCurso() {
        GrupoModel curso = new GrupoModel();
        curso.setRbd(1);
        curso.setGrado(1);
        curso.setLetra("A");
        curso.setJornada(1);

        when(cursoService.obtenerCurso(1)).thenReturn(curso);

        ResponseEntity<GrupoModel> response = datosGrupoMatriculaController.obtenerCurso(1);

        assertNotNull(response);
        assertNotNull(response.getBody());
        verify(cursoService, times(1)).obtenerCurso(1);
    }

    @Test
    public void eliminarCurso() {
        when(cursoService.eliminarCurso(1)).thenReturn(true);

        ResponseEntity<Void> response = datosGrupoMatriculaController.eliminarCurso(1);

        assertNotNull(response);
        verify(cursoService, times(1)).eliminarCurso(1);
    }
}
