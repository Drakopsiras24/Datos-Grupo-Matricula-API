package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import cl.mineduc.sidep.datosgrupomatriculaapi.enums.TipoJornada;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GrupoCommandModel {

    @NotNull(message = "RBD no puede estar vacio")
    private Integer rbd;

    @NotNull(message = "Grado no puede estar vacio")
    private Long grado;

    @NotBlank(message = "Debe indicar una letra para el grupo")
    private String letra;

    @NotNull(message = "Debe indicar un tipo de jornada")
    private TipoJornada jornada;

    @NotNull(message = "Debe indicar un Cupo")
    @Min(value = 1, message = "Debe indicar al menos un valor mayor o igual a 1")
    private Integer cupo;

    @Valid
    private Asistente educador;

}
