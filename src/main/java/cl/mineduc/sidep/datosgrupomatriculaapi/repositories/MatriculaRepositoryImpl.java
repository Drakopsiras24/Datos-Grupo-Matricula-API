package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.MatriculaGrupoMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaQueryModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatriculaRepositoryImpl implements MatriculaRepository {

    private final MatriculaGrupoMapper mapper;

    @Override
    public void save(MatriculaEntity m) {
        try {
            this.mapper.save(m);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al guardar Matricula: %s", e.getMessage()), e);
        }
    }

    @Override
    public List<MatriculaQueryModel> findAll(Integer rbd, Integer rut) {
        try {
            return  this.mapper.findAll(rbd, rut);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al consultar Matricula: %s", e.getMessage()), e);
        }
    }
}
