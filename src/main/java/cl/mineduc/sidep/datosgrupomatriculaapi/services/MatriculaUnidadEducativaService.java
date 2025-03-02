package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.MatriculaUnidadEducativaQueryModel;

import java.util.List;

public interface MatriculaUnidadEducativaService {

    void save(MatriculaUnidadEducativaCommandModel model);

    List<MatriculaUnidadEducativaQueryModel>  findAll(Integer rbd,Integer rut);

}
