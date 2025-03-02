package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import org.apache.ibatis.annotations.Param;

public interface ParvuloMapper {

    Long findByRut(@Param("rut") Integer rut);

}
