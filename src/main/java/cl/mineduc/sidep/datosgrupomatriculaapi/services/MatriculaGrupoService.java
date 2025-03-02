package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaQueryModel;

import java.util.List;

public interface MatriculaGrupoService {

    void save(MatriculaCommandModel model);

    List<MatriculaQueryModel> findAll(Integer rbd, Integer rut);

}
