package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.Matricula;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.MatriculaGrupoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MatriculaControllerTest {

    @Mock
    private MatriculaGrupoService matriculaGrupoService;

    @InjectMocks
    private  MatriculaController matriculaController;

    @Test
    public void shouldSaveMatricula() {
        doNothing().when(matriculaGrupoService).save(any(MatriculaCommandModel.class));
        this.matriculaController.save(new MatriculaCommandModel());
        verify(matriculaGrupoService, times(1)).save(any(MatriculaCommandModel.class));
    }

}