package com.example.demohibernate.service;

import java.util.List;

public interface ICoreService<E> {
    List<E> findAll();

    E findById(Long id);

    void create(E e);

    void update(E e);

    void delete(Long id);
}
