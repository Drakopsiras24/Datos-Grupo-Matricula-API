package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrupoMapper {

    // Método para insertar un nuevo grupo
    void insertGrupo(GrupoModel curso);

    // Método para obtener un grupo por RBD
    GrupoModel getGrupoByRBD(@Param("rbd") Integer rbd);

    // Método para actualizar los datos de un grupo
    void updateGrupo(GrupoModel curso);

    // Método para eliminar un grupo
    int deleteGrupo(@Param("rbd") Integer rbd);

    // Método para obtener un grupo con parámetros específicos
    GrupoModel getGrupoByParametros(@Param("rbd") Integer rbd,
                                             @Param("grado") Integer grado,
                                             @Param("letra") String letra);
}
