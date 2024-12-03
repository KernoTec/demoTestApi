package com.kernotec.test.domain.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String entity){
        super(String.format("Entidad no fue encontrada"));
    }
    public EntityNotFoundException(){
        super(String.format("Entidad no fue encontrada"));
    }
}
