package com.example.phone_management.service;

import com.example.phone_management.model.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService<E> {
  Iterable<E> findAll();

  Optional<E> findById(Long id);

  SmartPhone save(SmartPhone smartPhone);

  void remove(Long id);
}
