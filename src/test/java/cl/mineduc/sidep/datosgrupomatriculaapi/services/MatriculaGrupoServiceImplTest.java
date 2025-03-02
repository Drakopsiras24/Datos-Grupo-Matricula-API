package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.enums.TipoJornada;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.GrupoRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.MatriculaRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.MatriculaUnidadEducativaRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.ParvuloRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MatriculaGrupoServiceImplTest {

    @Mock
    private MatriculaRepository matriculaRepository;

    @Mock
    private GrupoRepository grupoRepository;

    @Mock
    private MatriculaUnidadEducativaRepository matriculaUnidadEducativaRepository;

    @InjectMocks
    private MatriculaGrupoServiceImpl service;

    private final MatriculaCommandModel model = new MatriculaCommandModel();
    private final MatriculaUnidadEducativaQueryModel mue =  new MatriculaUnidadEducativaQueryModel();

    @Before
    public void init() {
        model.setRbd(1);
        model.setGrado(1L);
        model.setRun(1);
        model.setDv("9");
        model.setLetra("A");
        model.setFechaMatricula(LocalDate.now());
        model.setJornada(TipoJornada.TARDE);
        model.setJornadaExtendida(Boolean.TRUE);

        mue.setId(1L);

    }

    @Test
    public void shouldFindMatriculaUnidadEducativaOnSave() {
        when(matriculaUnidadEducativaRepository.findAll(anyInt(), anyInt()))
                .thenReturn(Collections.singletonList(mue));
        this.service.save(model);
        verify(this.matriculaUnidadEducativaRepository, times(1)).findAll(anyInt(), anyInt());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrowExceptionWhenIsEmpty() {
        when(matriculaUnidadEducativaRepository.findAll(anyInt(), anyInt()))
                .thenReturn(Collections.emptyList());
        this.service.save(model);
    }

    @Test
    public void shouldFindGrupoOnSave() {
        when(matriculaUnidadEducativaRepository.findAll(anyInt(), anyInt()))
                .thenReturn(Collections.singletonList(mue));
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        this.service.save(model);
        verify(grupoRepository, times(1)).findIdGrupo(anyLong(), anyLong(), anyInt(), anyString());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrowExceptionWhenGrupoNotFoundOnSave() {
        when(matriculaUnidadEducativaRepository.findAll(anyInt(), anyInt()))
                .thenReturn(Collections.singletonList(mue));
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(null);
        this.service.save(model);
    }

    @Test
    public void shouldSaveMatricula() {
        when(matriculaUnidadEducativaRepository.findAll(anyInt(), anyInt()))
                .thenReturn(Collections.singletonList(mue));
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        doNothing().when(matriculaRepository).save(any());
        this.service.save(model);
        verify(matriculaRepository, times(1)).save(any());
    }

    @Test
    public void shouldReturnMatriculas() {
        when(matriculaRepository.findAll(anyInt(), anyInt()))
                .thenReturn(Collections.emptyList());
        assertNotNull(this.service.findAll(1, 1));
    }

}