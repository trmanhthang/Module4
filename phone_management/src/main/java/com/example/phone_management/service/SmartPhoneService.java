package com.example.phone_management.service;

import com.example.phone_management.model.SmartPhone;
import com.example.phone_management.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SmartPhoneService implements ISmartPhoneService<SmartPhone> {
  @Autowired
  private ISmartPhoneRepository iSmartPhoneRepository;

  @Override
  public Iterable<SmartPhone> findAll() {
    return iSmartPhoneRepository.findAll();
  }

  @Override
  public Optional<SmartPhone> findById(Long id) {
    return iSmartPhoneRepository.findById(id);
  }

  @Override
  public SmartPhone save(SmartPhone smartPhone) {
    return iSmartPhoneRepository.save(smartPhone);
  }

  @Override
  public void remove(Long id) {
    iSmartPhoneRepository.deleteById(id);
  }
}
