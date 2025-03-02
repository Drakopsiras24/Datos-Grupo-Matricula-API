package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.entities.PlantaGrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.enums.RolGrupo;
import cl.mineduc.sidep.datosgrupomatriculaapi.enums.TipoJornada;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Asistente;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoCommandModel;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;
    private final UnidadEducativaRepository unidadEducativaRepository;
    private final JornadaRepository jornadaRepository;
    private final GradoRepository  gradoRepository;
    private final PersonaRepository personaRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final PlantaRepository plantaRepository;
    private final PlantaGrupoRepository plantaGrupoRepository;


    @Transactional
    @Override
    public void crearCurso(GrupoCommandModel model) {
        Long unidadEducativa = this.findUnidadEducativaByRbd(model.getRbd());
        Long jornada = this.findJornada(unidadEducativa, model.getJornada());
        Long grado = this.findGrado(unidadEducativa, model.getGrado());
        Long persona = this.findPersona(model.getEducador().getRut());
        Long funcionario = this.findFuncionario(persona);
        Long planta = this.findPlanta(funcionario, unidadEducativa);


        GrupoEntity g = new  GrupoEntity();
        g.setJornada(jornada);
        g.setGrado(grado);
        g.setLetra(model.getLetra());
        g.setCupo(model.getCupo());

        this.grupoRepository.save(g);


        PlantaGrupoEntity entity = new PlantaGrupoEntity();
        entity.setGrupo(g.getId());
        entity.setPlanta(planta);
        entity.setRol(RolGrupo.EDUCADOR.getId());

        this.plantaGrupoRepository.save(entity);

    }

    @Override
    public List<GrupoQueryModel> findByRbd(Integer rbd) {

        List<GrupoQueryModel> grupos = this.grupoRepository.findModelByRbd(rbd);
        for (GrupoQueryModel grupo : grupos) {
            grupo.setAsistentes(this.plantaGrupoRepository.findAsistentes(rbd, grupo.getId()));
        }

        return grupos;
    }

    @Transactional
    @Override
    public void saveAsistentes(AsistenteCommandModel model) {

        Long unidadEducativa = this.findUnidadEducativaByRbd(model.getRbd());

        Long grupo = this.grupoRepository.findIdGrupo(model.getGrado(), model.getJornada().getId(), model.getRbd(), model.getLetra());
        if (grupo == null) {
            throw new DatosGrupoMatriculaException("Grupo no encontrado");
        }

        for (Asistente asistente : model.getAsistentes()) {
            Long persona = this.findPersona(asistente.getRut());
            Long funcionario = this.findFuncionario(persona);
            Long planta = this.findPlanta(funcionario, unidadEducativa);

            PlantaGrupoEntity entity = new PlantaGrupoEntity();
            entity.setGrupo(grupo);
            entity.setPlanta(planta);
            entity.setRol(RolGrupo.ASISTENTE.getId());

            this.plantaGrupoRepository.save(entity);

        }

    }

    @Transactional
    @Override
    public void update(GrupoCommandModel model) {
        Long grupo = this.grupoRepository.findIdGrupo(model.getGrado(), model.getJornada().getId(), model.getRbd(), model.getLetra());
        if (grupo == null) {
            throw new DatosGrupoMatriculaException("Grupo no encontrado");
        }

        Long unidadEducativa = this.findUnidadEducativaByRbd(model.getRbd());
        Long jornada = this.findJornada(unidadEducativa, model.getJornada());
        Long grado = this.findGrado(unidadEducativa, model.getGrado());
        Long persona = this.findPersona(model.getEducador().getRut());
        Long funcionario = this.findFuncionario(persona);
        Long planta = this.findPlanta(funcionario, unidadEducativa);

        GrupoEntity g = new  GrupoEntity();
        g.setId(grupo);
        g.setJornada(jornada);
        g.setGrado(grado);
        g.setLetra(model.getLetra());
        g.setCupo(model.getCupo());

        this.grupoRepository.update(g, grupo);

        this.plantaGrupoRepository.deleteByGrupoAndPlanta(grupo, planta);

        PlantaGrupoEntity plantaGrupo = new PlantaGrupoEntity();
        plantaGrupo.setRol(RolGrupo.EDUCADOR.getId());
        plantaGrupo.setPlanta(planta);
        plantaGrupo.setGrupo(grupo);

        this.plantaGrupoRepository.save(plantaGrupo);

    }

    @Override
    public List<GrupoQueryModel> findByRbdAndGradoAndLetra(Integer rbd, Long grado, String letra) {
        List<GrupoQueryModel> grupos = this.grupoRepository.findByRbdAndGradoAndLetra(rbd, grado, letra);
        for (GrupoQueryModel grupo : grupos) {
            grupo.setAsistentes(this.plantaGrupoRepository.findAsistentes(rbd, grupo.getId()));
        }
        return grupos;
    }

    private Long findUnidadEducativaByRbd(Integer rbd) {
        Long unidadEducativa = this.unidadEducativaRepository.findIdUnidadEducativaByRbd(rbd);
        if (unidadEducativa == null){
            throw new DatosGrupoMatriculaException("Unidad educativa no encontrada");
        }
        return unidadEducativa;
    }

    private Long findJornada(Long unidadEducativa, TipoJornada tipoJornada) {
        Long jornada = this.jornadaRepository.findByUnidadEducativaAndTipo(unidadEducativa, tipoJornada.getId());
        if (jornada == null){
            throw new DatosGrupoMatriculaException("Jornada no encontrada");
        }
        return jornada;
    }

    private Long findGrado(Long unidadEducativa, Long tipo) {
        Long grado = this.gradoRepository.findByTipoAndUnidadEducativa(unidadEducativa, tipo);
        if (grado == null){
            throw new DatosGrupoMatriculaException("Grado no encontrada");
        }
        return grado;
    }

    private Long findPersona(Integer rut) {
        Long persona = this.personaRepository.findByRut(rut);
        if (persona == null){
            throw new DatosGrupoMatriculaException("Persona no encontrada");
        }

        return persona;
    }

    private Long findFuncionario(Long persona) {
        Long funcionario = this.funcionarioRepository.findByPersona(persona);
        if (funcionario == null){
            throw new DatosGrupoMatriculaException("Funcionario no encontrado");
        }
        return funcionario;
    }


    private Long findPlanta(Long funcionario, Long unidadEducativa) {
        Long planta = this.plantaRepository.findByFuncionario(funcionario, unidadEducativa);
        if (planta == null){
            throw new DatosGrupoMatriculaException("Planta no encontrada");
        }
        return planta;
    }
}
