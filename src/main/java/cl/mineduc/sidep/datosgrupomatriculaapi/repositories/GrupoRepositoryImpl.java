package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GrupoDatabaseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
