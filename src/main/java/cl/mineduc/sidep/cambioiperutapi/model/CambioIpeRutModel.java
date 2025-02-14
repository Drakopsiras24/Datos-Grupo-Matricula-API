package cl.mineduc.sidep.cambioiperutapi.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CambioIpeRutModel {
    private Integer ipe;
    private Integer rut;
    private String dv;
    private LocalDateTime fechaActualizacion;
}
