package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GradoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoQueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradoMapper {

    void save(@Param("g") GradoEntity g);

    List<GradoQueryModel> findAll(@Param("unidadEducativa") Long unidadEducativa, @Param("tipo") Long tipo);

}
