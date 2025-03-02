package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.PlantaGrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.PlantaGrupoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlantaGrupoRepositoryImplTest {

    @Mock
    private PlantaGrupoMapper mapper;

    @InjectMocks
    private PlantaGrupoRepositoryImpl repository;

    @Test
    public void shouldSave() {
        doNothing().when(mapper).save(any(PlantaGrupoEntity.class));
        this.repository.save(new PlantaGrupoEntity());
        verify(this.mapper).save(any(PlantaGrupoEntity.class));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldReturnExceptionWhenSaving() {
        doThrow(MyBatisSystemException.class).when(mapper).save(any(PlantaGrupoEntity.class));
        this.repository.save(new PlantaGrupoEntity());
    }

}