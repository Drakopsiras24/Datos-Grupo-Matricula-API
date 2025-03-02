package cl.mineduc.sidep.datosgrupomatriculaapi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RolPlanta {

    EDUCADOR(1L),
    ASISTENTE(2L);

    private final Long id;

    public static RolPlanta valueOf(Long id) {
        for (RolPlanta rolPlanta : RolPlanta.values()) {
            if (rolPlanta.getId().equals(id)) {
                return rolPlanta;
            }
        }
        return null;
    }

}
