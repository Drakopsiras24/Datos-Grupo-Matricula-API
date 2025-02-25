package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"rbd", "ensenanza", "grado", "letra", "jornada", "cupo", "educador"})
public class CursoMatriculaModel {
    private Integer rbd;  // RBD del establecimiento
    private Integer ensenanza;  // Código de enseñanza (opcional)
    private Integer grado;  // Código del grado
    private String letra;  // Letra del curso
    private String jornada;  // Jornada [MAÑANA, TARDE, MAÑANAYTARDE, VESPERTINO]
    private Integer cupo;  // Cupo del curso (opcional)

    private Educador educador;  // Profesor jefe del curso

    @Data
    public static class Educador {
        private Integer rut;  // RUT del educador sin DV
        private String dv;    // DV del educador
    }
}
