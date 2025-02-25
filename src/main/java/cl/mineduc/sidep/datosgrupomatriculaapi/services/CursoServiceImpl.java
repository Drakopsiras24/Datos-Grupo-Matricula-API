package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.UnidadEducativaMapper;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    private final UnidadEducativaMapper unidadEducativaMapper;

    public CursoServiceImpl(UnidadEducativaMapper unidadEducativaMapper) {
        this.unidadEducativaMapper = unidadEducativaMapper;
    }

    // Métodos existentes
    @Override
    public void crearCurso(CursoMatriculaModel model) {
        unidadEducativaMapper.insertUnidadEducativa(model);
    }

    @Override
    public void actualizarCurso(CursoMatriculaModel model) {
        unidadEducativaMapper.updateUnidadEducativa(model);
    }

    @Override
    public CursoMatriculaModel obtenerCurso(Integer rbd) {
        return unidadEducativaMapper.getUnidadEducativaByRBD(rbd);
    }

    @Override
    public boolean eliminarCurso(int rbd) {
        int rowsAffected = unidadEducativaMapper.deleteUnidadEducativa(rbd);  // Se guarda el número de filas afectadas
        return rowsAffected > 0;  // Si hay filas afectadas, significa que se eliminó correctamente
    }


    // Implementamos el nuevo método para obtener un curso con parámetros
    @Override
    public CursoMatriculaModel obtenerCursoConParametros(Integer rbd, Integer ensenanza, Integer grado, String letra) {
        return unidadEducativaMapper.getUnidadEducativaByParametros(rbd, ensenanza, grado, letra);
    }
}
