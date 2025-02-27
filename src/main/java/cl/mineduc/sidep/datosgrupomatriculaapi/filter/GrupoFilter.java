package cl.mineduc.sidep.datosgrupomatriculaapi.filter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GrupoFilter {
    private Long id;    // fk_grup_id_jornada
    private Long grado;      // fk_grup_id_grado
    private String letra;      // grup_letra
    private Integer cupo;      // grup_cupo
    private String fechaCreacionDesde;
    private String fechaCreacionHasta;
    private Integer limit;
    private Integer offset;
    private String orderBy;  // nombre de la columna
    private String order;    // ASC o DESC
}
