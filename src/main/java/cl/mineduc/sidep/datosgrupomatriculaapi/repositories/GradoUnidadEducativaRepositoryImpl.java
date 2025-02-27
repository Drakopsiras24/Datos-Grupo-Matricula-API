package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GradoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GradoMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GradoUnidadEducativaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Slf4j
public class GradoUnidadEducativaRepositoryImpl implements GradoUnidadEducativaRepository {

    private final GradoUnidadEducativaMapper gradoUnidadEducativaMapper;

    @Override
    public Long findIdUnidadEducativaByRbd(Integer rbd) {
        try {
            return this.gradoUnidadEducativaMapper.findIdUnidadEducativaByRbd(rbd);
        } catch (MyBatisSystemException e) {
            log.error("Error al obtener ID de unidad educativa");
            throw new DatosGrupoMatriculaException("Error al obtener ID de unidad educativa", e);
        }
    }
}
