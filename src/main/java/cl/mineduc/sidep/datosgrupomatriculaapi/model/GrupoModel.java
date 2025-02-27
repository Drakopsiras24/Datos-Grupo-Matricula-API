package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GrupoModel {

    @ApiModelProperty(position = 1)
    private Integer rbd; // Identificador del establecimiento (correspondiente al "rbd")

    @ApiModelProperty(position = 2)
    private Integer grado; // Identificador del grado (correspondiente al "grado")

    @ApiModelProperty(position = 3)
    private String letra; // Letra del grupo (A, B, C...)

    @ApiModelProperty(position = 4)
    private Integer jornada; // Correlacionado con "pk_grup_id_grupo", jornada del curso (ejemplo: 1 para MAÑANA)

    @ApiModelProperty(position = 5)
    private Integer cupo; // Número de cupos disponibles para el grupo

    @ApiModelProperty(position = 6)
    private Educador educador = null; // Educador en null, ya que no se está insertando por ahora

    // Inner class para el Educador
    @Data
    public static class Educador {

        private Integer rut;  // rut del educador

        private String dv;    // dv del educador (dígito verificador)
    }
}
