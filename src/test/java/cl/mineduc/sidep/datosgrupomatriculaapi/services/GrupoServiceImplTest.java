package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.entities.PlantaGrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.enums.TipoJornada;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Asistente;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GrupoServiceImplTest {

    @Mock
    private GrupoRepository grupoRepository;
    @Mock
    private UnidadEducativaRepository unidadEducativaRepository;
    @Mock
    private JornadaRepository jornadaRepository;
    @Mock
    private PersonaRepository personaRepository;
    @Mock
    private FuncionarioRepository funcionarioRepository;
    @Mock
    private PlantaRepository plantaRepository;
    @Mock
    private PlantaGrupoRepository plantaGrupoRepository;

    @Mock
    private GradoRepositoryImpl gradoRepository;


    @InjectMocks
    private GrupoServiceImpl grupoService;

    private final GrupoCommandModel model = new GrupoCommandModel();

    @Before
    public void init() {

        Asistente educador = new Asistente();
        educador.setRut(1);
        educador.setDv("9");

        model.setRbd(1);
        model.setGrado(1L);
        model.setLetra("A");
        model.setJornada(TipoJornada.MANANA);
        model.setCupo(20);
        model.setEducador(educador);

    }

    @Test
    public void shouldFindUnidadEducativaWhenSaving() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        this.grupoService.crearCurso(model);
        verify(this.unidadEducativaRepository, times(1)).findIdUnidadEducativaByRbd(anyInt());
    }

    @Test(expected= DatosGrupoMatriculaException.class)
    public void shouldThrowExceptionWhenUnidadEducativaIsNull() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(null);
        this.grupoService.crearCurso(model);

    }

    @Test
    public void shouldFindJornadaWhenSaving() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        this.grupoService.crearCurso(model);
        verify(this.jornadaRepository).findByUnidadEducativaAndTipo(anyLong(), anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenJornadaIsNNull() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(null);
        this.grupoService.crearCurso(model);
    }

    @Test
    public void shouldFindGradoWhenSaving() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        this.grupoService.crearCurso(model);
        verify(this.gradoRepository).findByTipoAndUnidadEducativa(anyLong(), anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenGradoIsNull() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(null);
        this.grupoService.crearCurso(model);
    }

    @Test
    public void shouldSaveGrupo() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        doNothing().when(grupoRepository).save(any());
        this.grupoService.crearCurso(model);
        verify(grupoRepository).save(any(GrupoEntity.class));
    }

    @Test
    public void shouldFindPersona() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        doNothing().when(grupoRepository).save(any());

        this.grupoService.crearCurso(model);
        verify(personaRepository).findByRut(anyInt());

    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThownExceptionWhenPersonaIsNull() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(null);

        this.grupoService.crearCurso(model);
    }

    @Test
    public void shouldFindAFuncionarioWhenSaving() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);
        doNothing().when(grupoRepository).save(any());

        this.grupoService.crearCurso(model);
        verify(funcionarioRepository).findByPersona(any());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownAnExceptionWhenFuncionarioNotFound() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(null);

        this.grupoService.crearCurso(model);
    }

    @Test
    public void shouldFindPlanta() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong())).thenReturn(1L);
        doNothing().when(grupoRepository).save(any());

        this.grupoService.crearCurso(model);
        verify(plantaRepository).findByFuncionario(anyLong(), anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenPlantaNotFound() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong())).thenReturn(null);

        this.grupoService.crearCurso(model);
    }

    @Test
    public void shouldSavePlantaGrupo() {
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt())).thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong())).thenReturn(1L);
        doNothing().when(grupoRepository).save(any());
        doNothing().when(plantaGrupoRepository).save(any());

        this.grupoService.crearCurso(model);

        verify(plantaGrupoRepository).save(any(PlantaGrupoEntity.class));
    }


}