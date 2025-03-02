package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoQueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrupoDatabaseMapper {

    void save(GrupoEntity g);

    List<GrupoQueryModel> findModelByRbd(@Param("rbd") Integer rbd);

    Long findIdGrupo(
            @Param("grado") Long grado,
            @Param("jornada") Long jornada,
            @Param("rbd") Integer rbd,
            @Param("letra") String letra);

}
