package cl.mineduc.sidep.datosgrupomatriculaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaUnidadEducativaEntity {

    private Long id;
    private Long unidadEducativa;
    private Long parvulo;
    private LocalDateTime fechaMatricula;
    private String jornadaExtendida;

}
