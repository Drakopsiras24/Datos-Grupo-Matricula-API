package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import org.apache.ibatis.annotations.Param;

public interface PlantaMapper {

  Long findIdByFuncionario(@Param("funcionario") Long funcionario, @Param("unidadEducativa") Long unidadEducativa);

}
