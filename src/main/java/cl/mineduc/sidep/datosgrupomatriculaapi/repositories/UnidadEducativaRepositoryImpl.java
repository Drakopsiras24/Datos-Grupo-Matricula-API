package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.UnidadEducativaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Slf4j
public class UnidadEducativaRepositoryImpl implements UnidadEducativaRepository {

    private final UnidadEducativaMapper gradoUnidadEducativaMapper;

    @Override
    public Long findIdUnidadEducativaByRbd(Integer rbd) {
        try {
            return this.gradoUnidadEducativaMapper.findIdUnidadEducativaByRbd(rbd);
        } catch (MyBatisSystemException e) {
            log.error("Error al obtener ID de unidad educativa", e);
            throw new DatosGrupoMatriculaException("Error al obtener ID de unidad educativa", e);
        }
    }



}
