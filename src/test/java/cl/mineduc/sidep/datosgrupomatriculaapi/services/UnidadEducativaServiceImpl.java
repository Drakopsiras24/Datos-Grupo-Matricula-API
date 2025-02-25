package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.UnidadEducativaMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UnidadEducativaServiceImpl implements UnidadEducativaService {

    private final UnidadEducativaMapper unidadEducativaMapper;

    @Autowired
    public UnidadEducativaServiceImpl(UnidadEducativaMapper unidadEducativaMapper) {
        this.unidadEducativaMapper = unidadEducativaMapper;
    }

    // Implementación para crear una nueva unidad educativa
    @Override
    public void crearUnidadEducativa(CursoMatriculaModel curso) {
        unidadEducativaMapper.insertUnidadEducativa(curso);
    }

    // Implementación para obtener una unidad educativa por RBD
    @Override
    public CursoMatriculaModel obtenerUnidadEducativa(Integer rbd) {
        return unidadEducativaMapper.getUnidadEducativaByRBD(rbd);
    }

    // Implementación para actualizar una unidad educativa
    @Override
    public void actualizarUnidadEducativa(CursoMatriculaModel curso) {
        unidadEducativaMapper.updateUnidadEducativa(curso);
    }

    // Implementación para eliminar una unidad educativa por RBD
    @Override
    public void eliminarUnidadEducativa(Integer rbd) {
        unidadEducativaMapper.deleteUnidadEducativa(rbd);
    }
}
