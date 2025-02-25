package cl.mineduc.sidep.datosgrupomatriculaapi.exception;

public class DatosGrupoMatriculaException extends RuntimeException {

    public DatosGrupoMatriculaException(String message) {
        super(message);
    }

    public DatosGrupoMatriculaException(String message, Throwable cause) {
        super(message, cause);
    }
}
