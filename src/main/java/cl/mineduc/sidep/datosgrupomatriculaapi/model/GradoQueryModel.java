package cl.mineduc.sidep.datosgrupomatriculaapi.model;


import lombok.Data;

@Data
public class GradoQueryModel {

    private final Long id;
    private final Integer rbd;
    private final Long tipo;
    private final String tipoNombre;

}
