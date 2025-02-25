package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.CursoService;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    @Override
    public void crearCurso(CursoMatriculaModel curso) {
        // Lógica para crear un curso
    }

    @Override
    public void actualizarCurso(CursoMatriculaModel curso) {
        // Lógica para actualizar un curso
    }

    @Override
    public CursoMatriculaModel obtenerCurso(Integer rbd) {
        // Lógica para obtener un curso por RBD
        return new CursoMatriculaModel(); // Retornar el modelo de curso adecuado
    }

    @Override
    public boolean eliminarCurso(int rbd) {
        // Lógica para eliminar un curso
        return true;
    }
}
