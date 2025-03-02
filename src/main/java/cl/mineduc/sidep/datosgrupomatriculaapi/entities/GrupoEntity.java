package cl.mineduc.sidep.datosgrupomatriculaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoEntity {

    private Long id;
    private Long jornada;
    private Long grado;
    private String letra;
    private Integer cupo;

}
