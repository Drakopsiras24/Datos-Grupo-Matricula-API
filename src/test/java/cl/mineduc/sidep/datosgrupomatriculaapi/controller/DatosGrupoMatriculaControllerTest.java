package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.enums.TipoJornada;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.*;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.AsistenteService;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.CursoService;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.GrupoService;
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
    private MatriculaService matriculaService;

    @Mock
    private GrupoService grupoService;

    @InjectMocks
    private DatosGrupoMatriculaController datosGrupoMatriculaController;

    @Before
    public void setUp() {
        // Configuración inicial si es necesaria
    }

    @Test
    public void crearCurso() {
        GrupoCommandModel curso = new GrupoCommandModel();
        curso.setRbd(1);

        doNothing().when(grupoService).crearCurso(any(GrupoCommandModel.class));

        ResponseEntity<Void> response = datosGrupoMatriculaController.crearCurso(curso);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    public void agregarAsistentes() {

        AsistenteCommandModel amodel = new  AsistenteCommandModel();
        amodel.setRbd(1);
        amodel.setJornada(TipoJornada.MANANA);
        amodel.setLetra("A");
        amodel.setGrado(1L);

        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        asistentes.add(asistente);
        asistentes.add(asistente);
        asistentes.add(asistente);

        amodel.setAsistentes(asistentes);

        doNothing().when(grupoService).saveAsistentes(any(AsistenteCommandModel.class));
        this.datosGrupoMatriculaController.agregarAsistentes(amodel);
        verify(this.grupoService).saveAsistentes(any(AsistenteCommandModel.class));
    }




    @Test
    public void actualizarCurso() {
        doNothing().when(grupoService).update(any());
        this.datosGrupoMatriculaController.actualizarCurso(new  GrupoCommandModel());
        verify(grupoService, times(1)).update(any());
    }

    @Test
    public void obtenerCurso() {
        GrupoQueryModel curso = new GrupoQueryModel();
        curso.setRbd(1);

        when(grupoService.findByRbd(anyInt())).thenReturn(Collections.singletonList(curso));
        assertNotNull(datosGrupoMatriculaController.obtenerCurso(1));

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
