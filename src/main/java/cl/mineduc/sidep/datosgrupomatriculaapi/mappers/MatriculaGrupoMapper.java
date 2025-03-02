package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaQueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MatriculaGrupoMapper {

    void save(MatriculaEntity m);

    List<MatriculaQueryModel> findAll(@Param("rbd") Integer rbd, @Param("rut") Integer rut);


}
