package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.UnidadEducativaMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class UnidadEducativaServiceImpl implements UnidadEducativaService {

    private final UnidadEducativaMapper unidadEducativaMapper;

    @Autowired
    public UnidadEducativaServiceImpl(UnidadEducativaMapper unidadEducativaMapper) {
        this.unidadEducativaMapper = unidadEducativaMapper;
    }

    @Override
    public void crearUnidadEducativa(CursoMatriculaModel curso) {
        unidadEducativaMapper.insertUnidadEducativa(curso);
    }

    @Override
    public CursoMatriculaModel obtenerUnidadEducativa(Integer rbd) {
        return Optional.ofNullable(unidadEducativaMapper.getUnidadEducativaByRBD(rbd))
                .orElseThrow(() -> new RuntimeException("Unidad Educativa no encontrada"));
    }

    @Override
    public void actualizarUnidadEducativa(CursoMatriculaModel curso) {
        unidadEducativaMapper.updateUnidadEducativa(curso);
    }

    @Override
    public void eliminarUnidadEducativa(Integer rbd) {
        unidadEducativaMapper.deleteUnidadEducativa(rbd);
    }
}
