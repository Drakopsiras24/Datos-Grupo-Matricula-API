package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class MatriculaUnidadEducativaCommandModel {

    @NotNull(message = "RUN es obligatorio")
    private Integer run;

    @NotBlank(message = "Digito Verificador es obligatorio")
    private String dv;

    @NotNull(message = "RBD es obligatorio")
    private Integer rbd;

    @NotNull(message = "Fecha de Matricula debe ser obligatoria")
    private LocalDate fechaMatricula;

}
