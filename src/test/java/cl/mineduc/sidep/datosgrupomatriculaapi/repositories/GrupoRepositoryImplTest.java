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

import java.util.Collections;

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

    @Test
    public void shouldReturnGrupos() {
        when(mapper.findModelByRbd(anyInt()))
                .thenReturn(Collections.emptyList());
        assertNotNull(this.grupoRepository.findModelByRbd(1));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenLookingForGrupos() {
        when(mapper.findModelByRbd(anyInt()))
                .thenThrow(MyBatisSystemException.class);
        this.grupoRepository.findModelByRbd(1);
    }

    @Test
    public void shouldReturnID() {
        when(mapper.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        assertNotNull(this.grupoRepository.findIdGrupo(1L, 1L, 1, "A"));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrowExceptionWhenLookingForGrupos() {
        when(mapper.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenThrow(MyBatisSystemException.class);
        this.grupoRepository.findIdGrupo(1L, 1L, 1, "A");
    }

    @Test
    public void shouldUpdate() {
        doNothing().when(mapper).update(any(), anyLong());
        this.grupoRepository.update(new GrupoEntity(), 1L);
        verify(this.mapper).update(any(), anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenErrorOnUpodate() {
        doThrow(MyBatisSystemException.class).when(mapper).update(any(), anyLong());
        this.grupoRepository.update(new GrupoEntity(), 1L);
    }

    @Test
    public void shouldFindByRbdGradoAndLetra() {
        when(mapper.findByRbdAndGradoAndLetra(anyInt(), anyLong(), anyString())).thenReturn(Collections.emptyList());
        assertNotNull(this.grupoRepository.findByRbdAndGradoAndLetra(1, 1L, "A"));
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenFindByRbdAndGradoAndLetra() {
        when(mapper.findByRbdAndGradoAndLetra(anyInt(), anyLong(), anyString()))
                .thenThrow(MyBatisSystemException.class);
        this.grupoRepository.findByRbdAndGradoAndLetra(1, 1L, "A");
    }

}