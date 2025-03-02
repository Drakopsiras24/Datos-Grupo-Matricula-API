package cl.mineduc.sidep.datosgrupomatriculaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoQueryModel {

    @JsonIgnore
    private Long id;

    private Integer rbd;
    private String grado;
    private String letra;
    private String jornada;
    private Integer cupo;
    private Asistente educador;
    private List<Asistente> asistentes;

}
