package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GrupoDatabaseMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoQueryModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class GrupoRepositoryImpl implements GrupoRepository {

    private final GrupoDatabaseMapper mapper;

    @Override
    public void save(GrupoEntity entity) {
        try {
            this.mapper.save(entity);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException("Error al guardar Grupo", e);
        }
    }

    @Override
    public List<GrupoQueryModel> findModelByRbd(Integer rbd) {
        try {
            return this.mapper.findModelByRbd(rbd);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al buscar grupos en base de datos: %s", e.getMessage()), e);
        }
    }

    @Override
    public Long findIdGrupo(Long grado, Long jornada, Integer rbd, String letra) {
        try {
            return this.mapper.findIdGrupo(grado, jornada, rbd, letra);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al buscar Grupo en Base de Datos: %s", e.getMessage()), e);
        }
    }

    @Override
    public void update(GrupoEntity entity, Long id) {
        try {
            this.mapper.update(entity, id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al actualizar Grupo: %s", e.getMessage()), e);
        }
    }

    @Override
    public List<GrupoQueryModel> findByRbdAndGradoAndLetra(Integer rbd, Long grado, String letra) {
        try {
            return this.mapper.findByRbdAndGradoAndLetra(rbd, grado, letra);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al obtener grupo: %s", e.getMessage()), e);
        }
    }
}
