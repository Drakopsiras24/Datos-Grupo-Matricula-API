package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.JornadaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JornadaRepositoryImplTest {

    @Mock
    private JornadaMapper jornadaMapper;

    @InjectMocks
    private JornadaRepositoryImpl jornadaRepository;

    @Test
    public void shouldReturnJornada() {

        when(jornadaMapper.findByUnidadEducativaAndTipo(anyLong(),anyLong()))
                .thenReturn(1L);
        assertNotNull(jornadaRepository.findByUnidadEducativaAndTipo(1L, 1L));

    }

    @Test(expected= DatosGrupoMatriculaException.class)
    public void shouldThrowAnException() {
        when(jornadaMapper.findByUnidadEducativaAndTipo(anyLong(),anyLong()))
                .thenThrow(MyBatisSystemException.class);
        this.jornadaRepository.findByUnidadEducativaAndTipo(1L, 1L);
    }

}