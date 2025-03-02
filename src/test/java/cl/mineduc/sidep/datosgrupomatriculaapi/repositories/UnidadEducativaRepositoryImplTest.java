package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.UnidadEducativaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UnidadEducativaRepositoryImplTest {

    @Mock
    private UnidadEducativaMapper mapper;

    @InjectMocks
    private  UnidadEducativaRepositoryImpl repository;

    @Test
    public void shouldFindUnidadEducativaById() {
        when(mapper.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        assertNotNull(this.repository.findIdUnidadEducativaByRbd(1));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldReturnMyBatisSistemException(){
        when(repository.findIdUnidadEducativaByRbd(anyInt()))
                .thenThrow(MyBatisSystemException.class);

        this.repository.findIdUnidadEducativaByRbd(1);

    }

}