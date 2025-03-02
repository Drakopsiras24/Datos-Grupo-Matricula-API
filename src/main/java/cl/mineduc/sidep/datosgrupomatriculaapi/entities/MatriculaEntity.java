package cl.mineduc.sidep.datosgrupomatriculaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaEntity {

    private Long id;
    private Long matriculaUnidadEducativa;
    private Long grupo;
    private String jornadaExtendida;
    private LocalDateTime fechaMatricula;

}
