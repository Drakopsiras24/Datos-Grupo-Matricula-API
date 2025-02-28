package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GrupoMapper;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    private final GrupoMapper grupoMapper;

    // Constructor donde inyectamos el GrupoMapper
    public CursoServiceImpl(GrupoMapper grupoMapper) {
        this.grupoMapper = grupoMapper;
    }

    // Métodos actualizados que ahora utilizan GrupoMapper

    @Override
    public void crearCurso(GrupoModel model) {
        // Utilizamos GrupoMapper para insertar el nuevo curso
        grupoMapper.insertGrupo(model);
    }

    @Override
    public void actualizarCurso(GrupoModel model) {
        // Utilizamos GrupoMapper para actualizar el curso
        grupoMapper.updateGrupo(model);
    }

    @Override
    public GrupoModel obtenerCurso(Integer rbd) {
        // Obtenemos el curso usando el GrupoMapper
        return grupoMapper.getGrupoByRBD(rbd);
    }

    @Override
    public boolean eliminarCurso(int rbd) {
        // Elimina el curso utilizando el GrupoMapper
        return grupoMapper.deleteGrupo(rbd) > 0;
    }

    // Implementamos el nuevo método para obtener un curso con parámetros
    @Override
    public GrupoModel obtenerCursoConParametros(Integer rbd, Integer grado, String letra) {
        // Buscamos el curso con parámetros específicos usando GrupoMapper
        return grupoMapper.getGrupoByParametros(rbd, grado, letra);
    }

    @Override
    public Integer obtenerIdPorRbd(Integer rbd) {
        // Buscar el curso por su rbd en la base de datos
        GrupoModel curso = grupoMapper.getGrupoByRBD(rbd);
        if (curso != null) {
            return curso.getRbd(); // Retornar el id si se encuentra el curso
        }
        throw new RuntimeException("Curso no encontrado para el RBD: " + rbd);
    }
}
