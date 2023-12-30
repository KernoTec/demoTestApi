package com.kernotec.test.mapper;

public interface IMapper<E, K> {

    K toDto(E entity);
    E toEntity(K dto, boolean isNew);
}
