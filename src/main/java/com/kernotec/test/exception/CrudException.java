package com.kernotec.test.exception;

import com.kernotec.test.util.CustomUtil;

public class CrudException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String DATA_ACCESS = CustomUtil.getErrorPersistenceMsgsProperty("DataAcces.error");

    public CrudException(String message) {
        super(message);
    }
}
