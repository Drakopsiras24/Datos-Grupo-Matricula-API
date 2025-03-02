package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.GrupoRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.MatriculaRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.MatriculaUnidadEducativaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaGrupoServiceImpl implements MatriculaGrupoService {

    private final MatriculaUnidadEducativaRepository matriculaUnidadEducativaRepository;
    private final GrupoRepository grouperRepository;
    private final MatriculaRepository matriculaRepository;

    @Override
    public void save(MatriculaCommandModel model) {
        List<MatriculaUnidadEducativaQueryModel> matriculas =
                this.matriculaUnidadEducativaRepository.findAll(model.getRbd(), model.getRun());
        if (matriculas.isEmpty()) {
            throw new DatosGrupoMatriculaException("No se encuentran matriculas asociadas a este run y este RBD");
        }

        MatriculaUnidadEducativaQueryModel last =  matriculas.get(matriculas.size() - 1);

        Long grupo = this.grouperRepository.findIdGrupo(model.getGrado(), model.getJornada().getId(), model.getRbd(), model.getLetra());
        if (grupo == null) {
            throw new DatosGrupoMatriculaException("Grupo no encontrado");
        }

        MatriculaEntity m = new  MatriculaEntity();
        m.setGrupo(grupo);
        m.setMatriculaUnidadEducativa(last.getId());
        m.setJornadaExtendida(Boolean.TRUE.equals(model.getJornadaExtendida()) ? "SI" : "NO");
        m.setFechaMatricula(model.getFechaMatricula().atStartOfDay());

        this.matriculaRepository.save(m);
    }

    @Override
    public List<MatriculaQueryModel> findAll(Integer rbd, Integer rut) {
        return this.matriculaRepository.findAll(rbd, rut);
    }
}
