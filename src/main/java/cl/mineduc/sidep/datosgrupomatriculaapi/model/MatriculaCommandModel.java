package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import cl.mineduc.sidep.datosgrupomatriculaapi.enums.TipoJornada;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class MatriculaCommandModel {

    @NotNull(message = "RBD es obligatorio")
    private Integer rbd;

    @NotNull(message = "Grado es obligatorio")
    private Long grado;

    @NotNull(message = "RUN es obligatorio")
    private Integer run;

    @NotBlank(message = "DV es obligatorio")
    private String dv;

    @NotBlank(message = "Letra del grupo es obligatoria")
    private String letra;

    @NotNull(message = "Fecha de Matricula es obligatoria")
    private LocalDate fechaMatricula;

    @NotNull(message = "Jornada es obligatoria")
    private TipoJornada jornada;

    @NotNull(message = "Debe indicar jornada extendida")
    private Boolean jornadaExtendida;


}
