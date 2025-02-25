package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.CursoAsistenteMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoAsistenteMapper cursoAsistenteMapper;

    @Autowired
    public CursoServiceImpl(CursoAsistenteMapper cursoAsistenteMapper) {
        this.cursoAsistenteMapper = cursoAsistenteMapper;
    }

    // Implementación del método para crear un curso
    @Override
    public void crearCurso(CursoMatriculaModel curso) {
        // Lógica para agregar un nuevo curso
    }

    // Implementación del método para actualizar un curso
    @Override
    public void actualizarCurso(CursoMatriculaModel curso) {
    }

    // Implementación del método para obtener un curso por su RBD
    @Override
    public CursoMatriculaModel obtenerCurso(Integer rbd) {
        // Lógica para obtener un curso basado en el RBD
        return new CursoMatriculaModel(); // Ejemplo
    }

    @Override
    public boolean eliminarCurso(int rbd) {
        // Lógica para eliminar el curso
        // Si el curso es eliminado correctamente, retorna true, de lo contrario, false
        return true; // o false dependiendo de la lógica
    }

}
