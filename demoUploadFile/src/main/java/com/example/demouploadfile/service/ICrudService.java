package com.example.demouploadfile.service;

import java.util.List;

public interface ICrudService<E> {
    List<E> findAll();

    E findById(Integer id);

    void save(E e);

    void delete(E e);
}
