package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GradoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoQueryModel;

import java.util.List;

public interface GradoRepository {

    void save(GradoEntity grado);

    List<GradoQueryModel> findByParams(Long unidadEducativa, Long tipo);

}
