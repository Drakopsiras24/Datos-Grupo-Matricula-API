package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoModel;

public interface CursoService {

    // Método para crear un curso
    void crearCurso(GrupoModel model);

    // Método para actualizar un curso
    void actualizarCurso(GrupoModel model);

    // Método para obtener un curso por su RBD
    GrupoModel obtenerCurso(Integer rbd);

    // Método para eliminar un curso
    boolean eliminarCurso(int rbd);

    // Agregar el nuevo método para obtener un curso con parámetros
    GrupoModel obtenerCursoConParametros(Integer rbd, Integer grado, String letra);

    // Nuevo método para obtener el ID por RBD
    Integer obtenerIdPorRbd(Integer rbd);  // Este es el método que vamos a agregar
}
