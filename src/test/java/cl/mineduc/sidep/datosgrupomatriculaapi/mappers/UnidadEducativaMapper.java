package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;
import org.apache.ibatis.annotations.Param;

public interface UnidadEducativaMapper {

    void insertUnidadEducativa(CursoMatriculaModel curso);

    CursoMatriculaModel getUnidadEducativaByRBD(@Param("rbd") Integer rbd);

    void updateUnidadEducativa(CursoMatriculaModel curso);

    void deleteUnidadEducativa(@Param("rbd") Integer rbd);
}
