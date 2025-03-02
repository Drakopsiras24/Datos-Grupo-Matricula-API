package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.ParvuloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParvuloRepositoryImplTest {

    @Mock
    private ParvuloMapper mapper;

    @InjectMocks
    private ParvuloRepositoryImpl repository;

    @Test
    public void shouldFindParvulo() {
        when(mapper.findByRut(anyInt())).thenReturn(1L);
        assertNotNull(this.repository.findByPersona(1));
    }

    @Test(expected= DatosGrupoMatriculaException.class)
    public void shouldThrowExceptionWhenErrorOnFindByRut() {
        when(mapper.findByRut(anyInt())).thenThrow(MyBatisSystemException.class);
        this.repository.findByPersona(1);
    }

}