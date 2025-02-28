package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.CursoAsistenteMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AsistenteServiceImplTest {

    @Mock
    private CursoAsistenteMapper cursoAsistenteMapper;

    @InjectMocks
    private AsistenteServiceImpl asistenteService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Inicializa los Mocks con la versión anterior de Mockito

        // Inyecta el Mock en la instancia real del servicio
        asistenteService = new AsistenteServiceImpl(cursoAsistenteMapper);
    }


    // ✅ Prueba para agregar asistente exitosamente
    @Test
    public void agregarAsistentes_Exito() {
        // Prepara el asistente
        AsistenteCurso.Asistente asistente = new AsistenteCurso.Asistente();
        asistente.setRut(12345678);
        asistente.setDv("9");

        // Configura el mock para que no lance excepción
        doNothing().when(cursoAsistenteMapper).insertAsistente(asistente);

        // Llama al método a probar
        boolean resultado = asistenteService.agregarAsistentes(asistente);

        // Verificaciones
        assertTrue(resultado); // Debe devolver true
        verify(cursoAsistenteMapper, times(1)).insertAsistente(asistente); // Verifica que se llamó una vez
    }


    // ✅ Prueba para fallo al agregar asistente (excepción)
    @Test
    public void agregarAsistentes_Error() {
        // Prepara el asistente
        AsistenteCurso.Asistente asistente = new AsistenteCurso.Asistente();
        asistente.setRut(12345678);
        asistente.setDv("9");

        // Configura el mock para lanzar una excepción
        doThrow(new RuntimeException("Error en BD")).when(cursoAsistenteMapper).insertAsistente(any());

        // Llama al método a probar
        boolean resultado = asistenteService.agregarAsistentes(asistente);

        // Verificaciones
        assertFalse(resultado); // Debe devolver false por el error
        verify(cursoAsistenteMapper, times(1)).insertAsistente(asistente); // Verifica que se llamó una vez
    }

    // ✅ Prueba para eliminar asistente (en blanco ya que no tiene lógica)
    @Test
    public void eliminarAsistente() {
        Integer rutAsistente = 12345678;

        asistenteService.eliminarAsistente(rutAsistente);

        verify(cursoAsistenteMapper, never()).insertAsistente(any());
    }
}
