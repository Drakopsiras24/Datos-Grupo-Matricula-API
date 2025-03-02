package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.PlantaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PlantaRepositoryImpl implements PlantaRepository {

    private final PlantaMapper plantaMapper;

    @Override
    public Long findByFuncionario(Long funcionario, Long unidadEducativa) {
        try {
            return this.plantaMapper.findIdByFuncionario(funcionario, unidadEducativa);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException("Error buscando Planta", e);
        }
    }

}
