package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.MatriculaGrupoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class MatriculaRepositoryImplTest {

    @Mock
    private MatriculaGrupoMapper mapper;

    @InjectMocks
    private MatriculaRepositoryImpl matriculaRepository;

    @Test
    public void shouldSave() {
        doNothing().when(mapper).save(any(MatriculaEntity.class));
        matriculaRepository.save(new MatriculaEntity());
        verify(mapper).save(any(MatriculaEntity.class));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionOnSave() {
        doThrow(MyBatisSystemException.class).when(mapper).save(any(MatriculaEntity.class));
        matriculaRepository.save(new MatriculaEntity());
    }

    @Test
    public void shouldReturnMatriculas() {
        when(this.mapper.findAll(anyInt(), anyInt()))
                .thenReturn(Collections.emptyList());
        assertNotNull(this.matriculaRepository.findAll(1, 1));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionOnFindAll() {
        when(this.mapper.findAll(anyInt(), anyInt()))
                .thenThrow(MyBatisSystemException.class);
        matriculaRepository.findAll(1, 1);
    }

}