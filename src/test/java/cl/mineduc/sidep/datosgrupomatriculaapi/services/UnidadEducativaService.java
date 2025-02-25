package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;

public interface UnidadEducativaService {

    // Método para crear una nueva unidad educativa
    void crearUnidadEducativa(CursoMatriculaModel curso);

    // Método para obtener una unidad educativa por su RBD
    CursoMatriculaModel obtenerUnidadEducativa(Integer rbd);

    // Método para actualizar una unidad educativa
    void actualizarUnidadEducativa(CursoMatriculaModel curso);

    // Método para eliminar una unidad educativa por RBD
    void eliminarUnidadEducativa(Integer rbd);
}
