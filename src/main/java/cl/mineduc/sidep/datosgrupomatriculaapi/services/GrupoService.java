package cl.mineduc.sidep.datosgrupomatriculaapi.services;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoCommandModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoQueryModel;

import java.util.List;

public interface GrupoService {

    void crearCurso(GrupoCommandModel model);

    List<GrupoQueryModel> findByRbd(Integer rbd);

    void saveAsistentes(AsistenteCommandModel model);

    void update(GrupoCommandModel model);

}
