package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.CursoAsistenteMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Slf4j
public class AsistenteServiceImpl implements AsistenteService {

    private final CursoAsistenteMapper cursoAsistenteMapper;

    @Autowired
    public AsistenteServiceImpl(CursoAsistenteMapper cursoAsistenteMapper) {
        this.cursoAsistenteMapper = cursoAsistenteMapper;
    }

    @Override
    public boolean agregarAsistentes(AsistenteCurso.Asistente asistente) {
        try {
            cursoAsistenteMapper.insertAsistente(asistente);
            return true;
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public void eliminarAsistente(Integer rut) {
        // Lógica para eliminar el asistente
    }
}
