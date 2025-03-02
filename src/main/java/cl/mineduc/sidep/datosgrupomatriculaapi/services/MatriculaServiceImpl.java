package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.MatriculaMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Matricula;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaMapper matriculaMapper;

    @Override
    public void ingresarMatricula(Matricula matricula) {
        matriculaMapper.insertMatricula(matricula); // Insertar matrícula en la base de datos
    }

    @Override
    public void actualizarMatricula(Matricula matricula) {
        matriculaMapper.updateMatricula(matricula); // Actualizar matrícula en la base de datos
    }

    @Override
    public boolean eliminarMatricula(int rbd, int rut) {
        int rowsAffected = matriculaMapper.deleteMatricula(rbd, rut); // Eliminar matrícula por RBD y Rut
        return rowsAffected > 0; // Si se eliminaron filas, significa que la operación fue exitosa
    }

    @Override
    public List<Matricula> obtenerMatriculasPorRbdYRut(int rbd, int rut) {
        return matriculaMapper.getMatriculasByRbdAndRut(rbd, rut); // Obtener matrículas por RBD y Rut
    }
}
