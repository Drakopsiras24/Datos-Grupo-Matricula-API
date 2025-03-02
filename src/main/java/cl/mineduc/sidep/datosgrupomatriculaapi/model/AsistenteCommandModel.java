package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import cl.mineduc.sidep.datosgrupomatriculaapi.enums.TipoJornada;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AsistenteCommandModel {

    @NotNull(message = "RBD es obligatorio")
    private Integer rbd;

    @NotNull(message = "Grado es obligatorio")
    private Long grado;

    @NotBlank(message = "Letra es Obligatoria")
    private String letra;

    @NotNull(message = "Jornada es obligatoria")
    private TipoJornada jornada;

    @NotNull(message = "Asistentes no puede estar vacio")
    @Size(min = 1, message = "Debe ingresar al menos un asistente")
    private List<Asistente> asistentes;

}
