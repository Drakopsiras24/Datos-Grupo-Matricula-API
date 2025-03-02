package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Asistente {

    @NotNull(message = "RUN es obligatorio")
    private Integer rut;

    @NotBlank(message = "Debe indicar un DV")
    private String dv;

}
