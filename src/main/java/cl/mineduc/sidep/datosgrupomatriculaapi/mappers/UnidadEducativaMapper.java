package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import org.apache.ibatis.annotations.Param;

public interface UnidadEducativaMapper {

    Long findIdUnidadEducativaByRbd(@Param("rbd") Integer rbd);

}
