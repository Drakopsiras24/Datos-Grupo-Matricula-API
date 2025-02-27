package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

import cl.mineduc.sidep.datosgrupomatriculaapi.entities.GradoEntity;

public interface GradoUnidadEducativaRepository {

    Long findIdUnidadEducativaByRbd(Integer rbd);

}
