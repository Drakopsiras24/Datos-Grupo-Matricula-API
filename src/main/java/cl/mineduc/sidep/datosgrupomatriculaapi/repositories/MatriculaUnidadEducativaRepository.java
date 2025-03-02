package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaUnidadEducativaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaQueryModel;

import java.util.List;

public interface MatriculaUnidadEducativaRepository {

    void save(MatriculaUnidadEducativaEntity m);

    List<MatriculaUnidadEducativaQueryModel> findAll(Integer rbd,Integer rut);

}
