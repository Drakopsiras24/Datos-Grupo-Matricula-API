package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.PlantaMapper;
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
public class PlantaRepositoryImplTest {

    @Mock
    private PlantaMapper mapper;

    @InjectMocks
    private PlantaRepositoryImpl repository;

    @Test
    public void shouldReturnAnId() {
        when(mapper.findIdByFuncionario(anyLong(), anyLong())).thenReturn(1L);
        assertNotNull(repository.findByFuncionario(1L, 1L));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldReturnAnException() {
        when(mapper.findIdByFuncionario(anyLong(), anyLong())).thenThrow(MyBatisSystemException.class);
        this.repository.findByFuncionario(1L, 1L);
    }

}