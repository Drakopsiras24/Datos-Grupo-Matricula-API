package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import org.apache.ibatis.annotations.Param;

public interface JornadaMapper {

    Long findByUnidadEducativaAndTipo(@Param("ue") Long unidadEducativa, @Param("t") Long tipo);

}
