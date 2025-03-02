package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GradoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.GradoMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoQueryModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Slf4j
public class GradoRepositoryImpl implements GradoRepository {

    private final GradoMapper gradoMapper;

    @Override
    public void save(GradoEntity grado) {
        try {
            this.gradoMapper.save(grado);
        } catch (MyBatisSystemException e) {
            log.error("Erro al guardar grado", e);
            throw new DatosGrupoMatriculaException("Error al guardar grado", e);
        }
    }

    @Override
    public List<GradoQueryModel> findByParams(Long unidadEducativa, Long tipo) {
        try {
            return this.gradoMapper.findAll(unidadEducativa, tipo);
        } catch (MyBatisSystemException e) {
            log.error("Error al consultar Grados", e);
            throw new DatosGrupoMatriculaException("Error consultar Grados", e);
        }
    }

    @Override
    public Long findByTipoAndUnidadEducativa(Long tipo, Long unidadEducativa) {
        try {
            return this.gradoMapper.findIdByTipoAndUnidadEducativa(tipo, unidadEducativa);
        } catch (MyBatisSystemException e) {
            log.error("Error al consultar Grados", e);
            throw new DatosGrupoMatriculaException(String.format("Error al consultar grado: %s", e.getMessage()), e);
        }
    }


}
