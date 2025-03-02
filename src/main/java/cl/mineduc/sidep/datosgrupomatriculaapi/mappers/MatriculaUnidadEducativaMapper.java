package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaUnidadEducativaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaQueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatriculaUnidadEducativaMapper {

    void save(MatriculaUnidadEducativaEntity m);

    List<MatriculaUnidadEducativaQueryModel> findAll(@Param("rbd") Integer rbd, @Param("rut") Integer rut);

}
