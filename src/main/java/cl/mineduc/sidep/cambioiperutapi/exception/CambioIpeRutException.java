package cl.mineduc.sidep.cambioiperutapi.exception;

public class CambioIpeRutException extends RuntimeException {

    public CambioIpeRutException(String message) {
        super(message);
    }

    public CambioIpeRutException(String message, Throwable cause) {
        super(message, cause);
    }
}
