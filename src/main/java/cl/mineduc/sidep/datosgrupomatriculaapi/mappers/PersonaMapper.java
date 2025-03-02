package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import org.apache.ibatis.annotations.Param;

public interface PersonaMapper {

    Long findByRut(@Param("rut") Integer rut);

}
