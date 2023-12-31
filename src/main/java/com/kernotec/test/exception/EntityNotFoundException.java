package com.kernotec.test.exception;

import com.kernotec.test.util.CustomUtil;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String CLASS_DOCUMENT = CustomUtil.getErrorPersistenceMsgsProperty("EntityNotFoundException.classDocument");
    public static final String GENDER = CustomUtil.getErrorPersistenceMsgsProperty("EntityNotFoundException.gender");;

    public static final String CLIENT = CustomUtil.getErrorPersistenceMsgsProperty("EntityNotFoundException.client");

    public static final String ENTITY_NOT_FOUND_ERROR = CustomUtil.getErrorPersistenceMsgsProperty("EntityNotFound.error");

    public EntityNotFoundException(String message) {
        super(message);
    }
}
