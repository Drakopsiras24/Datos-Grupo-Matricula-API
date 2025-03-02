package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.PlantaGrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.PlantaGrupoMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Asistente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PlantaGrupoRepositoryImpl implements PlantaGrupoRepository {

    private final PlantaGrupoMapper mapper;

    public void save(PlantaGrupoEntity entity) {
        try {
            this.mapper.save(entity);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al guardar en Planta Grupo: %s", e.getMessage()), e);
        }
    }

    @Override
    public List<Asistente> findAsistentes(Integer rbd, Long grupo) {
        try {
            return this.mapper.findAsistentes(rbd, grupo);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al consultar en Planta Grupo: %s", e.getMessage()), e);
        }
    }

    @Override
    public Asistente findEducador(Long grupo, Long planta) {
        try {
            return this.mapper.findEducador(grupo, planta);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al consultar en Planta Grupo: %s", e.getMessage()), e);
        }
    }

    @Override
    public void deleteByGrupoAndPlanta(Long grupo, Long planta) {
        try {
            this.mapper.deleteByGrupoAndPlanta(grupo, planta);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al eliminar en Planta Grupo: %s", e.getMessage()), e);
        }
    }

}
