package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;

public interface AsistenteService {

    // Método para agregar un asistente a un curso
    boolean agregarAsistentes(AsistenteCurso.Asistente asistente);

    // Método para eliminar un asistente de un curso
    void eliminarAsistente(Integer rut);
}
