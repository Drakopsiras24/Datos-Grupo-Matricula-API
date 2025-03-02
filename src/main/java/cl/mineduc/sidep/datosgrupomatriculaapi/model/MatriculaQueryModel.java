package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MatriculaQueryModel {

    @JsonIgnore
    private Long id;
    private Integer rbd;
    private Integer run;
    private String dv;
    private String grado;
    private String jornada;
    private LocalDate fechaMatricula;
    private LocalDate fechaRetiro;
    private String jornadaExtendida;


}
