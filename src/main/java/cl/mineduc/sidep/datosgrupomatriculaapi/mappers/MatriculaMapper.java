package cl.mineduc.sidep.datosgrupomatriculaapi.mappers;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.Matricula;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface MatriculaMapper {

    // Insertar una nueva matrícula
    void insertMatricula(Matricula matricula);

    // Actualizar una matrícula
    void updateMatricula(Matricula matricula);

    // Eliminar matrícula por RBD y Rut
    int deleteMatricula(@Param("rbd") Integer rbd, @Param("rut") Integer rut);

    // Obtener todas las matrículas por RBD y Rut
    List<Matricula> getMatriculasByRbdAndRut(@Param("rbd") Integer rbd, @Param("rut") Integer rut);
}
