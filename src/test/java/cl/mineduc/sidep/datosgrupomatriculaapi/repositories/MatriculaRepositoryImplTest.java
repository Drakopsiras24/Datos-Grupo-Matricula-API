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

    @Test(expected= DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionOnSave() {
        doThrow(MyBatisSystemException.class).when(mapper).save(any(MatriculaEntity.class));
        matriculaRepository.save(new MatriculaEntity());
    }

}