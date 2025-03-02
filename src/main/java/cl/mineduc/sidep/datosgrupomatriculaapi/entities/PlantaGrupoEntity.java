package cl.mineduc.sidep.datosgrupomatriculaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantaGrupoEntity {

    private Long id;
    private Long planta;
    private Long grupo;
    private Long rol;

}
