package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaUnidadEducativaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.MatriculaUnidadEducativaRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.ParvuloRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.UnidadEducativaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaUnidadEducativaServiceImpl implements MatriculaUnidadEducativaService {

    private final UnidadEducativaRepository unidadEducativaRepository;
    private final ParvuloRepository parvuloRepository;
    private final MatriculaUnidadEducativaRepository matriculaUnidadEducativaRepository;

    @Transactional
    @Override
    public void save(MatriculaUnidadEducativaCommandModel model) {
        Long unidadEducativa = this.unidadEducativaRepository.findIdUnidadEducativaByRbd(model.getRbd());
        if (unidadEducativa == null) {
            throw new DatosGrupoMatriculaException("Unidad educativa no encontrada.");
        }

        Long parvulo = this.parvuloRepository.findByPersona(model.getRun());
        if (parvulo == null) {
            throw new DatosGrupoMatriculaException("Parvulo no encontrado.");
        }

        MatriculaUnidadEducativaEntity entity = new MatriculaUnidadEducativaEntity();
        entity.setUnidadEducativa(unidadEducativa);
        entity.setParvulo(parvulo);
        entity.setFechaMatricula(model.getFechaMatricula().atStartOfDay());

        this.matriculaUnidadEducativaRepository.save(entity);

    }

    @Override
    public List<MatriculaUnidadEducativaQueryModel> findAll(Integer rbd, Integer rut) {
        return this.matriculaUnidadEducativaRepository.findAll(rbd, rut);
    }


}
