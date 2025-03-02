package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.MatriculaUnidadEducativaRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.ParvuloRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.UnidadEducativaRepository;
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
public class MatriculaUnidadEducativaServiceImplTest {

    @Mock
    private UnidadEducativaRepository unidadEducativaRepository;

    @Mock
    private MatriculaUnidadEducativaRepository matriculaUnidadEducativaRepository;

    @Mock
    private ParvuloRepository parvuloRepository;

    @InjectMocks
    private MatriculaUnidadEducativaServiceImpl service;

    private final MatriculaUnidadEducativaCommandModel model = new MatriculaUnidadEducativaCommandModel();

    @Before
    public void init() {

        model.setRun(1);
        model.setDv("9");
        model.setRbd(1);
        model.setFechaMatricula(LocalDate.now());

    }

    @Test
    public void shouldFindUnidadEducativaOnSave() {
        when(this.unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        this.service.save(model);
        verify(this.unidadEducativaRepository).findIdUnidadEducativaByRbd(anyInt());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenUnidadEducativaNotFoundOnSave() {
        when(this.unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(null);
        this.service.save(model);
    }

    @Test
    public void shouldFindParvuloOnSave() {
        when(this.unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(this.parvuloRepository.findByPersona(anyInt()))
                .thenReturn(1L);
        this.service.save(model);
        verify(this.parvuloRepository).findByPersona(anyInt());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shoulThrownExceptionWhenParvuloNotFound() {
        when(this.unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(this.parvuloRepository.findByPersona(anyInt()))
                .thenReturn(null);
        this.service.save(model);
    }

    @Test
    public void shouldSaveMatriculaUnidadEducativaOnSave() {
        doNothing().when(this.matriculaUnidadEducativaRepository).save(any());
        this.service.save(model);
        verify(this.matriculaUnidadEducativaRepository).save(any());
    }

    @Test
    public void shouldCallFindAll() {
        when(matriculaUnidadEducativaRepository.findAll(anyInt(), anyInt()))
                .thenReturn(Collections.emptyList());
        this.service.findAll(1, 1);
        verify(this.matriculaUnidadEducativaRepository).findAll(anyInt(), anyInt());
    }



}