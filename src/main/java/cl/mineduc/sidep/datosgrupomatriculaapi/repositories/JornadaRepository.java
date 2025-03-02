package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

public interface JornadaRepository {

    Long findByUnidadEducativaAndTipo(Long unidadEducativa, Long tipo);

}
