package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.entities.PlantaGrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.enums.TipoJornada;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Asistente;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

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
    private final AsistenteCommandModel amodel = new AsistenteCommandModel();

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

        amodel.setRbd(1);
        amodel.setJornada(TipoJornada.MANANA);
        amodel.setLetra("A");
        amodel.setGrado(1L);
        amodel.setAsistentes(Collections.emptyList());

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

    @Test
    public void shouldReturnGrupos() {
        when(this.grupoService.findByRbd(anyInt()))
                .thenReturn(Collections.emptyList());
        assertNotNull(this.grupoService.findByRbd(1));
    }

    @Test
    public void shouldLookForAsistentesWhenSearchingGrupos() {

        GrupoQueryModel  grupoQueryModel = new GrupoQueryModel();
        grupoQueryModel.setId(1L);
        grupoQueryModel.setRbd(1);
        grupoQueryModel.setCupo(10);
        grupoQueryModel.setLetra("A");
        grupoQueryModel.setJornada("MANANA");
        grupoQueryModel.setGrado("Cierto Grado");

        when(this.grupoService.findByRbd(anyInt()))
                .thenReturn(Collections.singletonList(grupoQueryModel));

        when(plantaGrupoRepository.findAsistentes(anyInt(), anyLong()))
                .thenReturn(Collections.emptyList());
        this.grupoService.findByRbd(1);
        verify(plantaGrupoRepository).findAsistentes(anyInt(), anyLong());

    }

    @Test
    public void shouldReturnIdWhenSearchingGrupos() {

        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        this.grupoService.saveAsistentes(amodel);
        verify(grupoRepository).findIdGrupo(anyLong(), anyLong(), anyInt(), anyString());
    }


    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenGrupoNotFound() {

        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(null);
        this.grupoService.saveAsistentes(amodel);

    }

    @Test
    public void shouldFindPersonaWhenSavingAsistentes() {

        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        asistentes.add(asistente);
        asistentes.add(asistente);
        asistentes.add(asistente);

        amodel.setAsistentes(asistentes);

        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);

        this.grupoService.saveAsistentes(amodel);
        verify(personaRepository, times(4)).findByRut(anyInt());

    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldReturnExceptionWhenSavingAsistenteAndPersonaIsNotFound() {
        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        amodel.setAsistentes(asistentes);

        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(null);
        this.grupoService.saveAsistentes(amodel);
    }

    @Test
    public void shouldFindFuncionarioWhenSavingAsistentes() {
        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        asistentes.add(asistente);
        asistentes.add(asistente);
        asistentes.add(asistente);

        amodel.setAsistentes(asistentes);

        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);

        this.grupoService.saveAsistentes(amodel);
        verify(funcionarioRepository, times(4)).findByPersona(anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenSavingAsistentesAndFuncionarioNotFound() {
        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        amodel.setAsistentes(asistentes);

        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(null);
        this.grupoService.saveAsistentes(amodel);
    }

    @Test
    public void shouldFindUnidadEducativaWhenSavingAsistente() {

        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        amodel.setAsistentes(asistentes);

        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);

        this.grupoService.saveAsistentes(amodel);
        verify(unidadEducativaRepository).findIdUnidadEducativaByRbd(anyInt());

    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenSavingAsistentesAndUnidadEducativaNotFound() {
        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        amodel.setAsistentes(asistentes);

        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(null);

        this.grupoService.saveAsistentes(amodel);
    }

    @Test
    public void shouldFindPlantaWhenSavingAsistentes() {
        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        amodel.setAsistentes(asistentes);

        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong())).thenReturn(1L);

        this.grupoService.saveAsistentes(amodel);
        verify(plantaRepository).findByFuncionario(anyLong(), anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenSavingAsistentesAndPlantaNotFound() {
        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        amodel.setAsistentes(asistentes);

        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong())).thenReturn(null);

        this.grupoService.saveAsistentes(amodel);
    }

    @Test
    public void shouldSavePlantaGrupoWhenSavingAsistentes() {
        Asistente asistente = new Asistente();
        asistente.setRut(1);
        asistente.setDv("9");

        ArrayList<Asistente> asistentes = new ArrayList<>();
        asistentes.add(asistente);
        asistentes.add(asistente);
        asistentes.add(asistente);
        asistentes.add(asistente);

        amodel.setAsistentes(asistentes);

        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt())).thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong())).thenReturn(1L);
        doNothing().when(plantaGrupoRepository).save(any(PlantaGrupoEntity.class));

        this.grupoService.saveAsistentes(amodel);
        verify(plantaGrupoRepository, times(4)).save(any(PlantaGrupoEntity.class));

    }

    @Test
    public void shouldFindGrupoWhenUpdateting() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        this.grupoService.update(model);
        verify(grupoRepository).findIdGrupo(anyLong(), anyLong(), anyInt(), anyString());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenGrupoNotFoundOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(null);
        this.grupoService.update(model);
    }

    @Test
    public void shouldFindUnidadEducativaWhenUpdating() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        this.grupoService.update(model);
        verify(unidadEducativaRepository).findIdUnidadEducativaByRbd(anyInt());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenUnidadEducativaNotFoundOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(null);
        this.grupoService.update(model);
    }

    @Test
    public void shouldFindJornadaWhenUpdating() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        this.grupoService.update(model);
        verify(jornadaRepository).findByUnidadEducativaAndTipo(anyLong(), anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenJornadaNotFoundOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(null);
        this.grupoService.update(model);
    }

    @Test
    public void shouldFindGradoWhenUpdateing() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        this.grupoService.update(model);
        verify(gradoRepository).findByTipoAndUnidadEducativa(anyLong(), anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenGradoNotFoundOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(null);
        this.grupoService.update(model);
    }

    @Test
    public void shouldFindPersonaWhenUpdateing() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(1L);
        this.grupoService.update(model);
        verify(personaRepository).findByRut(anyInt());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenPersonaNotFoundOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(null);
        this.grupoService.update(model);
    }

    @Test
    public void shouldFindFuncionarioOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong()))
                .thenReturn(1L);
        this.grupoService.update(model);
        verify(funcionarioRepository).findByPersona(anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenFuncionarioNotFoundOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong()))
                .thenReturn(null);
        this.grupoService.update(model);
    }

    @Test
    public void shouldFindPlantaOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong()))
                .thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong()))
                .thenReturn(1L);
        this.grupoService.update(model);
        verify(plantaRepository).findByFuncionario(anyLong(), anyLong());
    }

    @Test(expected = DatosGrupoMatriculaException.class)
    public void shouldThrownExceptionWhenPlantaNotFoundOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong()))
                .thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong()))
                .thenReturn(null);
        this.grupoService.update(model);
    }

    @Test
    public void shouldUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong()))
                .thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong()))
                .thenReturn(1L);
        doNothing().when(grupoRepository).update(any(), anyLong());

        this.grupoService.update(model);

        verify(grupoRepository).update(any(), anyLong());

    }

    @Test
    public void shouldDeleteEducadorOnUpdate() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong()))
                .thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong()))
                .thenReturn(1L);
        doNothing().when(grupoRepository).update(any(), anyLong());
        doNothing().when(plantaGrupoRepository).deleteByGrupoAndPlanta(anyLong(), anyLong());

        this.grupoService.update(model);
        verify(plantaGrupoRepository).deleteByGrupoAndPlanta(anyLong(), anyLong());
    }

    @Test
    public void shouldSaveNewEducadorWhenUpdating() {
        when(grupoRepository.findIdGrupo(anyLong(), anyLong(), anyInt(), anyString()))
                .thenReturn(1L);
        when(unidadEducativaRepository.findIdUnidadEducativaByRbd(anyInt()))
                .thenReturn(1L);
        when(jornadaRepository.findByUnidadEducativaAndTipo(anyLong(), anyLong()))
                .thenReturn(1L);
        when(gradoRepository.findByTipoAndUnidadEducativa(anyLong(), anyLong()))
                .thenReturn(1L);
        when(personaRepository.findByRut(anyInt()))
                .thenReturn(1L);
        when(funcionarioRepository.findByPersona(anyLong())).thenReturn(1L);
        when(plantaRepository.findByFuncionario(anyLong(), anyLong()))
                .thenReturn(1L);
        doNothing().when(grupoRepository).update(any(), anyLong());
        doNothing().when(plantaGrupoRepository).deleteByGrupoAndPlanta(anyLong(), anyLong());
        doNothing().when(plantaGrupoRepository).save(any());
        this.grupoService.update(model);
        verify(plantaGrupoRepository).save(any());
    }

    @Test
    public void shouldFindGrupoByRbdAndGradoAndLetra() {

        when(grupoRepository.findByRbdAndGradoAndLetra(anyInt(), anyLong(), anyString()))
                .thenReturn(Collections.emptyList());
        assertNotNull(this.grupoService.findByRbdAndGradoAndLetra(1, 1L, "A"));
        verify(grupoRepository).findByRbdAndGradoAndLetra(anyInt(), anyLong(), anyString());

    }

    @Test
    public void shouldSearchForAsistentes() {

        GrupoQueryModel grupoQueryModel = new GrupoQueryModel();
        grupoQueryModel.setId(1L);
        grupoQueryModel.setRbd(1);
        grupoQueryModel.setCupo(10);
        grupoQueryModel.setLetra("A");
        grupoQueryModel.setJornada("MANANA");
        grupoQueryModel.setGrado("Cierto Grado");

        when(grupoRepository.findByRbdAndGradoAndLetra(anyInt(), anyLong(), anyString()))
                .thenReturn(Collections.singletonList(grupoQueryModel));
        when(plantaGrupoRepository.findAsistentes(anyInt(), anyLong()))
                .thenReturn(new ArrayList<>());

        this.grupoService.findByRbdAndGradoAndLetra(1, 1L, "A");
        verify(plantaGrupoRepository).findAsistentes(anyInt(), anyLong());

    }


}