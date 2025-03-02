package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.FuncionarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private final FuncionarioMapper funcionarioMapper;

    @Override
    public Long findByPersona(Long persona) {
        try {
            return funcionarioMapper.findByPersonaId(persona);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException("Error al obtener funcionario", e);
        }
    }

}
