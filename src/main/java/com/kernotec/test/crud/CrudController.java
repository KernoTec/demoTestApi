package com.kernotec.test.crud;

import java.util.List;

public interface CrudController<D> {

    D create(D dto);
    void update(D dto);
    void delete(String unique);
    D read(String unique);
    List<D> findAll();
}
