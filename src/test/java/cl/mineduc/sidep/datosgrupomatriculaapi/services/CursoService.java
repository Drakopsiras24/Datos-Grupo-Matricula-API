package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;

public interface CursoService {

    // Método para crear un curso
    void crearCurso(CursoMatriculaModel curso);

    // Método para actualizar un curso
    void actualizarCurso(CursoMatriculaModel curso);

    // Método para obtener un curso por su RBD
    CursoMatriculaModel obtenerCurso(Integer rbd);

    // Método para eliminar un curso
    boolean eliminarCurso(int rbd);
}
