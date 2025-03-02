package cl.mineduc.sidep.datosgrupomatriculaapi.repositories;

public interface PlantaRepository {

    Long findByFuncionario(Long funcionario, Long unidadEducativa);
}
