package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonPropertyOrder({"rbd", "ensenanza", "grado", "letra", "asistentes"}) // Esto controla el orden en el JSON
public class AsistenteCurso {

    @ApiModelProperty(position = 1, value = "RBD del establecimiento")
    private Integer rbd;  // RBD del establecimiento

    @ApiModelProperty(position = 2, value = "Código de enseñanza")
    private Integer ensenanza;  // Código de enseñanza

    @ApiModelProperty(position = 3, value = "Código del grado")
    private Integer grado;  // Código de grado

    @ApiModelProperty(position = 4, value = "Letra del curso")
    private String letra;  // Letra del curso

    @ApiModelProperty(position = 5, value = "Lista de asistentes al curso")
    private List<Asistente> asistentes;  // Lista de asistentes

    @Data
    public static class Asistente {

        @ApiModelProperty(position = 1, value = "RUT del asistente sin DV")
        private Integer rut;  // RUT del asistente sin DV

        @ApiModelProperty(position = 2, value = "DV del asistente")
        private String dv;    // DV del asistente
    }
}
