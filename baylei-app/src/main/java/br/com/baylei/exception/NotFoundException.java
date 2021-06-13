package br.com.baylei.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String cause, Throwable ex) {
        super(cause, ex);
    }

    public NotFoundException(String cause) {
        super(cause);
    }
}
