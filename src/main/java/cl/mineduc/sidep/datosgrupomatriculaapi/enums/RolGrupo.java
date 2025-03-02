package cl.mineduc.sidep.datosgrupomatriculaapi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RolGrupo {

    EDUCADOR(1L),
    ASISTENTE(2L);

    private final Long id;

    public static RolGrupo valueOf(Long id) {
        for (RolGrupo rolPlanta : RolGrupo.values()) {
            if (rolPlanta.getId().equals(id)) {
                return rolPlanta;
            }
        }
        return null;
    }

}
