package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonPropertyOrder({"rbd", "ensenanza", "grado", "letra", "jornada", "jornadaExtendida", "rut", "dv", "fechaMatricula"})
public class Matricula {

    @ApiModelProperty(position = 1)
    private Integer rbd;  // RBD del establecimiento, obligatorio

    @ApiModelProperty(position = 2)
    private Integer ensenanza;  // Código de enseñanza del curso, opcional

    @ApiModelProperty(position = 3)
    private Integer grado;  // Código de grado del curso, obligatorio

    @ApiModelProperty(position = 4)
    private String letra;  // Letra del curso (máximo 2 caracteres), obligatorio

    @ApiModelProperty(position = 5)
    private String jornada;  // Jornada del curso, obligatorio. Valores posibles: "MAÑANA", "TARDE", "MAÑANAYTARDE", "VESPERTINO"

    @ApiModelProperty(position = 6)
    private String jornadaExtendida;  // Jornada extendida, opcional. Valores posibles: "SI", "NO"

    @ApiModelProperty(position = 7)
    private Integer rut;  // Rut del estudiante sin dígito verificador, obligatorio

    @ApiModelProperty(position = 8)
    private String dv;  // Dígito verificador del rut del estudiante, obligatorio

    @ApiModelProperty(position = 9)
    private String fechaMatricula;  // Fecha de matrícula (formato dd-MM-yyyy), obligatorio
}
