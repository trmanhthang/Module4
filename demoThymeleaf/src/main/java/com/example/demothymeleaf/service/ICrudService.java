package com.example.demothymeleaf.service;


import java.util.List;

public interface ICrudService<E> {
    List<E> findAll();

    E findById(Long id);

    void add(E e);

    void deleteById(Long id);

//    Integer findByIndex(Long id);
}
