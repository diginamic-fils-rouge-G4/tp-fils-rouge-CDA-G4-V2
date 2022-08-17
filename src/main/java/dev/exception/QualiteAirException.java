package dev.exception;

public class QualiteAirException extends RuntimeException {

    public QualiteAirException() {

    }

    public QualiteAirException(String message) {
        super(message);
    }

    public QualiteAirException(String message, Throwable cause) {
        super(message, cause);
    }

    public QualiteAirException(Throwable cause) {
        super(cause);
    }
}
