package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.CursoAsistenteMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AsistenteServiceImpl implements AsistenteService {

    private final CursoAsistenteMapper cursoAsistenteMapper;

    @Autowired
    public AsistenteServiceImpl(CursoAsistenteMapper cursoAsistenteMapper) {
        this.cursoAsistenteMapper = cursoAsistenteMapper;
    }

    @Override
    public boolean agregarAsistentes(AsistenteCurso.Asistente asistente) {
        try {
            // Insertar el asistente individualmente
            cursoAsistenteMapper.insertAsistente(asistente);
            return true; // Si la inserción es exitosa
        } catch (Exception e) {
            return false; // Si ocurre un error
        }
    }

    @Override
    public void eliminarAsistente(Integer rut) {
        // Lógica para eliminar el asistente
    }
}
