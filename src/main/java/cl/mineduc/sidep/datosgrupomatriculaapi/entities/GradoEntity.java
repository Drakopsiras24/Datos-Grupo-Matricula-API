package cl.mineduc.sidep.datosgrupomatriculaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradoEntity {

    private Long id;
    private Long unidadEducativa;
    private Long tipo;

}
