package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GrupoDatabaseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GrupoRepositoryImplTest {

    @Mock
    private GrupoDatabaseMapper mapper;

    @InjectMocks
    private GrupoRepositoryImpl grupoRepository;

    @Test
    public void shouldSave() {
        doNothing().when(mapper).save(any(GrupoEntity.class));
        GrupoEntity entity = new GrupoEntity();
        this.grupoRepository.save(entity);
        verify(mapper).save(entity);
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldReturnException() {
        doThrow(MyBatisSystemException.class).when(mapper).save(any(GrupoEntity.class));
        this.grupoRepository.save(new GrupoEntity());
    }

}