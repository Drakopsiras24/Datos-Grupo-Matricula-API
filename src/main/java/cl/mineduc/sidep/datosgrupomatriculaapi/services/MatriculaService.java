package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.Matricula;
import java.util.List;

public interface MatriculaService {

    // Método para crear una nueva matrícula
    void ingresarMatricula(Matricula matricula);

    // Método para actualizar una matrícula
    void actualizarMatricula(Matricula matricula);

    // Método para eliminar una matrícula por RBD y Rut
    boolean eliminarMatricula(int rbd, int rut);

    // Método para obtener todas las matrículas por RBD y Rut
    List<Matricula> obtenerMatriculasPorRbdYRut(int rbd, int rut);
}
