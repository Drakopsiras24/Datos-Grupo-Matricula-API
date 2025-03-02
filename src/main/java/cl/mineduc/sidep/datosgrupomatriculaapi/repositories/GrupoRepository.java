package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.GrupoQueryModel;

import java.util.List;

public interface GrupoRepository {

    void save(GrupoEntity entity);

    List<GrupoQueryModel> findModelByRbd(Integer rbd);

    Long findIdGrupo(Long grado, Long jornada, Integer rbd, String letra);

}
