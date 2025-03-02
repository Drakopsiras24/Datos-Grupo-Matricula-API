package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.PlantaGrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Asistente;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlantaGrupoMapper {

    void save(PlantaGrupoEntity plantaGrupo);

    List<Asistente> findAsistentes(@Param("rbd") Integer rbd, @Param("grupo") Long grupo);

}
