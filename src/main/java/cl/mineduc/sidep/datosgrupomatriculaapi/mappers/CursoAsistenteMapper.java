package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;
import org.apache.ibatis.annotations.Param;

public interface CursoAsistenteMapper {

    void insertAsistente(AsistenteCurso.Asistente asistente);

    void deleteAsistente(@Param("rut") Integer rut);
}
