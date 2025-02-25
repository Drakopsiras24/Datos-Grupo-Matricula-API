package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;
import org.springframework.stereotype.Service;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.CursoAsistenteMapper;

@Service
public class AsistenteServiceImpl implements AsistenteService {

    private final CursoAsistenteMapper cursoAsistenteMapper;

    public AsistenteServiceImpl(CursoAsistenteMapper cursoAsistenteMapper) {
        this.cursoAsistenteMapper = cursoAsistenteMapper;
    }

    @Override
    public boolean agregarAsistentes(AsistenteCurso.Asistente asistente) {
        try {
            cursoAsistenteMapper.insertAsistente(asistente); // Inserción en las tablas correspondientes
            return true; // Si la inserción es exitosa
        } catch (Exception e) {
            return false; // Si ocurre un error
        }
    }

    @Override
    public void eliminarAsistente(Integer rut) {
        // Aquí se deben agregar las lógicas para eliminar asistentes en las tablas correctas.
    }
}
