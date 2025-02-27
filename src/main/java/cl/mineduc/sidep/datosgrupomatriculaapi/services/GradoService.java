package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GradoQueryModel;

import java.util.List;

public interface GradoService {

    void save(GradoCommandModel g);

    List<GradoQueryModel> findAll(Integer rbd, Long tipo);


}
