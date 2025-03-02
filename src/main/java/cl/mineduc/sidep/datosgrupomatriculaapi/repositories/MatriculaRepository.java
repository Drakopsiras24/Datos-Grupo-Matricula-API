package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.MatriculaEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaQueryModel;

import java.util.List;

public interface MatriculaRepository {

    void save(MatriculaEntity m);

    List<MatriculaQueryModel> findAll(Integer rbd, Integer rut);

}
