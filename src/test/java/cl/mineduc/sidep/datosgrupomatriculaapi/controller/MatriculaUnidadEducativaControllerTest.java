package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.MatriculaUnidadEducativaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MatriculaUnidadEducativaControllerTest {

    @Mock
    private MatriculaUnidadEducativaService matriculaUnidadEducativaService;

    @InjectMocks
    private MatriculaUnidadEducativaController matriculaUnidadEducativaController;

    @Test
    public void shouldCallSaveWhenPost() {
        doNothing().when(this.matriculaUnidadEducativaService).save(any());
        this.matriculaUnidadEducativaController.save(new MatriculaUnidadEducativaCommandModel());
        verify(this.matriculaUnidadEducativaService).save(any());
    }

    @Test
    public void shouldCallFindAllWhenGet() {
        when(matriculaUnidadEducativaService.findAll(anyInt(), anyInt())).thenReturn(Collections.emptyList());
        this.matriculaUnidadEducativaController.findAll(1,1);
        verify(matriculaUnidadEducativaService).findAll(anyInt(), anyInt());
    }

}