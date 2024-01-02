package com.kernotec.test.exception;

public class CrudExceptionRest extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CrudExceptionRest(String message) {
        super(message);
    }

    public CrudExceptionRest() {
        super();
    }
}
