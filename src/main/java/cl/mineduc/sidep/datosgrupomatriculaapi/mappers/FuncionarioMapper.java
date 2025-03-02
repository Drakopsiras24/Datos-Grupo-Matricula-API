package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import org.apache.ibatis.annotations.Param;

public interface FuncionarioMapper {

    Long findByPersonaId(@Param("persona") Long persona);

}
