package com.management.cgmanagement.service;


import java.util.Optional;

public interface GenericService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
