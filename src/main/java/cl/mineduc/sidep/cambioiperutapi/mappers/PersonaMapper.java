package cl.mineduc.sidep.cambioiperutapi.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface PersonaMapper {

    Long findByRut(Integer rut);

    void updateIpeToRut(@Param("ipe") Integer ipe, @Param("rut") Integer rut, @Param("dv") String dv);
}
