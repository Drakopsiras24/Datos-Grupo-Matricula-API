package cl.mineduc.sidep.cambioiperutapi.repositories;

import cl.mineduc.sidep.cambioiperutapi.mappers.PersonaMapper;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonaRepositoryImpl implements PersonaRepository {

    private final PersonaMapper personaMapper;

    @Override
    public Long findByRut(Integer rut) {
        try {
            return personaMapper.findByRut(rut);
        } catch (MyBatisSystemException e) {
            throw new cl.mineduc.sidep.cambioiperutapi.exception.CambioIpeRutException("Error al obtener persona", e);
        }
    }
}
