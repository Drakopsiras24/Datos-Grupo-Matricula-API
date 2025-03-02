package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GradoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GradoRepositoryImplTest {

    @Mock
    private GradoMapper gradoMapper;

    @InjectMocks
    private GradoRepositoryImpl gradoRepository;

    @Test
    public void shouldReturnAndIdWhenFindingGRadoByTipoAndUnidadEducativa() {
        when(this.gradoMapper.findIdByTipoAndUnidadEducativa(anyLong(), anyLong())).thenReturn(1L);
        assertNotNull(this.gradoRepository.findByTipoAndUnidadEducativa(1L, 1L));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownAnExceptionWhenFindingByTipoAndUnidadEducativa() {
        when(this.gradoMapper.findIdByTipoAndUnidadEducativa(anyLong(), anyLong())).thenThrow(MyBatisSystemException.class);
        this.gradoRepository.findByTipoAndUnidadEducativa(1L, 1L);
    }

}