package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import org.apache.ibatis.annotations.Param;

public interface GradoUnidadEducativaMapper {

    Long findIdUnidadEducativaByRbd(@Param("rbd") Integer rbd);

}
