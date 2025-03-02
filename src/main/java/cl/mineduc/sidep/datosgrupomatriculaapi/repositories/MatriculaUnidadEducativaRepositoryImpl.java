package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaUnidadEducativaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.exception.DatosGrupoMatriculaException;
import cl.mineduc.sidep.datosgrupomatriculaapi.mappers.MatriculaUnidadEducativaMapper;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaQueryModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MatriculaUnidadEducativaRepositoryImpl implements MatriculaUnidadEducativaRepository {

    private final MatriculaUnidadEducativaMapper mapper;

    @Override
    public void save(MatriculaUnidadEducativaEntity m) {
        try {
            this.mapper.save(m);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al guardar Matricula de Unidad Educativa: %s", e.getMessage()), e);
        }
    }

    @Override
    public List<MatriculaUnidadEducativaQueryModel> findAll(Integer rbd, Integer rut) {
        try {
            return this.mapper.findAll(rbd,rut);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new DatosGrupoMatriculaException(String.format("Error al obtener  Matricula de Unidad Educativa: %s", e.getMessage()), e);
        }
    }

}
