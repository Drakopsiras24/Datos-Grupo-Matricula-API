package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MatriculaUnidadEducativaQueryModel {

    @JsonIgnore
    private Long id;

    private Integer run;
    private String dv;
    private Integer rbd;
    private LocalDate fechaMatricula;
    private LocalDate fechaRetiro;

}
