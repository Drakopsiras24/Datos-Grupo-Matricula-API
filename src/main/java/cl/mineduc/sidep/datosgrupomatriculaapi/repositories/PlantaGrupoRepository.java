package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.PlantaGrupoEntity;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.Asistente;

import java.util.List;

public interface PlantaGrupoRepository {

    void save(PlantaGrupoEntity entity);

    List<Asistente> findAsistentes(Integer rbd, Long grupo);

    Asistente findEducador(Long grupo, Long planta);

    void deleteByGrupoAndPlanta(Long grupo, Long planta);

}
