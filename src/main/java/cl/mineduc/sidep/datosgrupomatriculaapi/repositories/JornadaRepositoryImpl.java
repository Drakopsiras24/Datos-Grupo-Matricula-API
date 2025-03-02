package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.JornadaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JornadaRepositoryImpl implements JornadaRepository {

    private final JornadaMapper mapper;

    public Long findByUnidadEducativaAndTipo(Long unidadEducativa, Long tipo) {
        try {
             return this.mapper.findByUnidadEducativaAndTipo(unidadEducativa, tipo);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al obtener el jornada por unidad educativa %s", e.getMessage()), e);
        }
    }

}
