package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonPropertyOrder({"rbd", "ensenanza", "grado", "letra", "jornada", "cupo", "educador"})
public class CursoMatriculaModel {

    @ApiModelProperty(position = 1)
    private Integer rbd;

    @ApiModelProperty(position = 2)
    private Integer ensenanza;

    @ApiModelProperty(position = 3)
    private Integer grado;

    @ApiModelProperty(position = 4)
    private String letra;

    @ApiModelProperty(position = 5)
    private String jornada;

    @ApiModelProperty(position = 6)
    private Integer cupo;

    @ApiModelProperty(position = 7)
    private Educador educador;

    @Data
    public static class Educador {

        @ApiModelProperty(position = 1)
        private Integer rut;

        @ApiModelProperty(position = 2)
        private String dv;
    }
}

