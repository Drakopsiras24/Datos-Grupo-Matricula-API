package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;
import org.apache.ibatis.annotations.Param;

public interface UnidadEducativaMapper {

    // Métodos existentes
    void insertUnidadEducativa(CursoMatriculaModel curso);
    CursoMatriculaModel getUnidadEducativaByRBD(@Param("rbd") Integer rbd);
    void updateUnidadEducativa(CursoMatriculaModel curso);
    int deleteUnidadEducativa(@Param("rbd") Integer rbd);

    // Agregamos el nuevo método para obtener un curso con los parámetros
    CursoMatriculaModel getUnidadEducativaByParametros(@Param("rbd") Integer rbd,
                                                       @Param("ensenanza") Integer ensenanza,
                                                       @Param("grado") Integer grado,
                                                       @Param("letra") String letra);
}
