package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GradoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoQueryModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.GradoRepository;
import cl.mineduc.sidep.datosgrupomatriculaapi.repositories.UnidadEducativaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradoServiceImpl implements GradoService {

    private final GradoRepository gradoRepository;
    private final UnidadEducativaRepository gradoUnidadEducativaRepository;

    @Override
    public void save(GradoCommandModel g) {

        Long unidadEducativa = this.gradoUnidadEducativaRepository.findIdUnidadEducativaByRbd(g.getRbd());
        if (unidadEducativa == null){
            throw new DatosGrupoMatriculaException("Unidad educativa no encontrada");
        }

        GradoEntity grado = new GradoEntity();
        grado.setUnidadEducativa(unidadEducativa);
        grado.setTipo(g.getCodigo());

        this.gradoRepository.save(grado);

    }

    @Override
    public List<GradoQueryModel> findAll(Integer rbd, Long tipo) {

        Long unidadEducativa = null;
        if (rbd != null) {
            unidadEducativa = this.gradoUnidadEducativaRepository.findIdUnidadEducativaByRbd(rbd);
            if (unidadEducativa == null){
                throw new DatosGrupoMatriculaException("Unidad educativa no encontrada");
            }
        }

        return this.gradoRepository.findByParams(unidadEducativa, tipo);
    }
}
