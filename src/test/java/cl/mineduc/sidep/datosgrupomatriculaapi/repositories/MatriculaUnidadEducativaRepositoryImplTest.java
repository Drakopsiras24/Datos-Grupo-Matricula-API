package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaUnidadEducativaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.MatriculaUnidadEducativaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MatriculaUnidadEducativaRepositoryImplTest {

    @Mock
    private MatriculaUnidadEducativaMapper mapper;

    @InjectMocks
    private MatriculaUnidadEducativaRepositoryImpl repository;

    @Test
    public void shouldSaveMatriculaUnidadEducativa() {
        doNothing().when(mapper).save(any());
        this.repository.save(new MatriculaUnidadEducativaEntity());
        verify(mapper).save(any());
    }

    @Test(expected= DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenSavingMatriculaUnidadEducativa() {
        doThrow(MyBatisSystemException.class).when(mapper).save(any());
        this.repository.save(new MatriculaUnidadEducativaEntity());
    }

    @Test
    public void shouldReturnMatriculaUnidadEducativa() {
        when(mapper.findAll(anyInt(), anyInt())).thenReturn(Collections.emptyList());
        assertNotNull(this.repository.findAll(1, 1));
    }

    @Test(expected= DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenErrorGettingMatriculaUnidadEducativa() {
        when(mapper.findAll(anyInt(), anyInt())).thenThrow(MyBatisSystemException.class);
        this.repository.findAll(1, 1);
    }

}