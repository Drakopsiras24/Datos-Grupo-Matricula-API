package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Matricula;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.AsistenteService;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.CursoService;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.MatriculaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DatosGrupoMatriculaControllerTest {

    @Mock
    private CursoService cursoService;

    @Mock
    private AsistenteService asistenteService;

    @Mock
    private MatriculaService matriculaService;

    @InjectMocks
    private DatosGrupoMatriculaController datosGrupoMatriculaController;

    @Before
    public void setUp() {
        // Configuración inicial si es necesaria
    }

    @Test
    public void crearCurso() {
        GrupoModel curso = new GrupoModel();
        curso.setRbd(1);

        doNothing().when(cursoService).crearCurso(any(GrupoModel.class));

        ResponseEntity<Void> response = datosGrupoMatriculaController.crearCurso(curso);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        verify(cursoService, times(1)).crearCurso(any(GrupoModel.class));
    }

    @Test
    public void agregarAsistentes() {
        AsistenteCurso asistenteCurso = new AsistenteCurso();
        AsistenteCurso.Asistente asistente = new AsistenteCurso.Asistente();
        asistente.setRut(12345678);
        asistenteCurso.setAsistentes(Collections.singletonList(asistente));

        // ✅ Cambio aquí: usar doNothing() para métodos void
        when(asistenteService.agregarAsistentes(any())).thenReturn(true); // Suponiendo que retorna `true` si es exitoso

        ResponseEntity<Void> response = datosGrupoMatriculaController.agregarAsistentes(asistenteCurso);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        verify(asistenteService, times(1)).agregarAsistentes(any());
    }




    @Test
    public void actualizarCurso() {
        GrupoModel curso = new GrupoModel();
        curso.setRbd(1);

        when(cursoService.obtenerIdPorRbd(anyInt())).thenReturn(1);
        doNothing().when(cursoService).actualizarCurso(any(GrupoModel.class));

        ResponseEntity<Void> response = datosGrupoMatriculaController.actualizarCurso(curso);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(cursoService, times(1)).actualizarCurso(any(GrupoModel.class));
    }

    @Test
    public void obtenerCurso() {
        GrupoModel curso = new GrupoModel();
        curso.setRbd(1);

        when(cursoService.obtenerCurso(anyInt())).thenReturn(curso);

        ResponseEntity<GrupoModel> response = datosGrupoMatriculaController.obtenerCurso(1);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        verify(cursoService, times(1)).obtenerCurso(anyInt());
    }

    @Test
    public void obtenerCursoNoEncontrado() {
        when(cursoService.obtenerCurso(anyInt())).thenReturn(null);

        ResponseEntity<GrupoModel> response = datosGrupoMatriculaController.obtenerCurso(1);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void eliminarCurso() {
        when(cursoService.eliminarCurso(anyInt())).thenReturn(true);

        ResponseEntity<Void> response = datosGrupoMatriculaController.eliminarCurso(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(cursoService, times(1)).eliminarCurso(anyInt());
    }

    @Test
    public void eliminarCursoNoEncontrado() {
        when(cursoService.eliminarCurso(anyInt())).thenReturn(false);

        ResponseEntity<Void> response = datosGrupoMatriculaController.eliminarCurso(1);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void ingresarMatricula() {
        Matricula matricula = new Matricula();
        matricula.setRbd(1);

        doNothing().when(matriculaService).ingresarMatricula(any(Matricula.class));

        ResponseEntity<Void> response = datosGrupoMatriculaController.ingresarMatricula(matricula);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        verify(matriculaService, times(1)).ingresarMatricula(any(Matricula.class));
    }

    @Test
    public void actualizarMatricula() {
        Matricula matricula = new Matricula();
        matricula.setRbd(1);

        doNothing().when(matriculaService).actualizarMatricula(any(Matricula.class));

        ResponseEntity<Void> response = datosGrupoMatriculaController.actualizarMatricula(matricula);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(matriculaService, times(1)).actualizarMatricula(any(Matricula.class));
    }

    @Test
    public void obtenerMatricula() {
        List<Matricula> matriculas = new ArrayList<>();
        matriculas.add(new Matricula());

        when(matriculaService.obtenerMatriculasPorRbdYRut(anyInt(), anyInt())).thenReturn(matriculas);

        ResponseEntity<List<Matricula>> response = datosGrupoMatriculaController.obtenerMatricula(1, 1);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        verify(matriculaService, times(1)).obtenerMatriculasPorRbdYRut(anyInt(), anyInt());
    }

    @Test
    public void eliminarMatricula() {
        // ✅ Ajuste aquí: usar doNothing() para métodos void
        when(matriculaService.eliminarMatricula(anyInt(), anyInt())).thenReturn(true); // Si se eliminó correctamente

        ResponseEntity<Void> response = datosGrupoMatriculaController.eliminarMatricula(1, 1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(matriculaService, times(1)).eliminarMatricula(anyInt(), anyInt());
    }
}
