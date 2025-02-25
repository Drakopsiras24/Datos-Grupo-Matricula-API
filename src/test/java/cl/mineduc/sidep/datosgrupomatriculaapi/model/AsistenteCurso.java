package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import lombok.Data;
import java.util.List;

@Data
public class AsistenteCurso {

    private Integer rbd;  // Identificador de la unidad educativa
    private Integer ensenanza;  // Código de la enseñanza del curso (opcional)
    private Integer grado;  // Código del grado del curso
    private String letra;  // Letra del curso (máximo 2 caracteres)
    private List<Asistente> asistentes;  // Lista de asistentes al curso

    @Data
    public static class Asistente {
        private Integer rut;  // RUT del asistente sin DV
        private String dv;    // DV del asistente
    }
}
