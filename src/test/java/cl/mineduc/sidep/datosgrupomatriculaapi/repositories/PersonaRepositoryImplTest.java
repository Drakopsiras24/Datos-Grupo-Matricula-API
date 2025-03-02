package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.PersonaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonaRepositoryImplTest {

    @Mock
    private PersonaMapper mapper;

    @InjectMocks
    private PersonaRepositoryImpl repository;

    @Test
    public void shouldReturnAndId() {
        when(mapper.findByRut(anyInt()))
                .thenReturn(1L);
        assertNotNull(repository.findByRut(1));
    }

    @Test(expected= DatosGrupoMatriculaException.class)
    public void shouldThrownAndExceptionWhenLookingForPersonaByRut() {
        Integer rut = 1;
        when(mapper.findByRut(rut)).thenThrow(MyBatisSystemException.class);
        repository.findByRut(rut);
    }

}