package cl.mineduc.sidep.datosgrupomatriculaapi.model;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GradoCommandModel {

    @NotNull(message = "RBD no puede estar vacio")
    private Integer rbd;

    @NotNull(message = "Código de Grado no puede estar nulo.")
    private Long codigo;


}
