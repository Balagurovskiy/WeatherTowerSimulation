package obalagur.avaj.exceptions;

public class AvajException extends Exception {
    public AvajException(ExceptionTypes exceptionTypes) {
        super(exceptionTypes.toString());
    }
}
