package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;


import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.PersonaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PersonaRepositoryImpl implements PersonaRepository {

    private final PersonaMapper personaMapper;

    @Override
    public Long findByRut(Integer rut) {
        try {
            return personaMapper.findByRut(rut);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException("Error al obtener persona", e);
        }
    }
}
