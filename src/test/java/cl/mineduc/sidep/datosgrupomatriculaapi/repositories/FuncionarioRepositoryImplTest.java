package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.FuncionarioMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class FuncionarioRepositoryImplTest {

    @Mock
    private FuncionarioMapper mapper;

    @InjectMocks
    private  FuncionarioRepositoryImpl repository;

    @Test
    public void shouldReturnAndId() {
        when(mapper.findByPersonaId(anyLong()))
                .thenReturn(1L);
        this.repository.findByPersona(1L);
        assertNotNull(repository.findByPersona(1L));
    }

    @Test(expected= DatosGrupoMatriculaException.class)
    public void shouldThrownAnExceptionWhenErrorInDatabase() {
        when(mapper.findByPersonaId(anyLong()))
                .thenThrow(MyBatisSystemException.class);
        this.repository.findByPersona(1L);
    }

}