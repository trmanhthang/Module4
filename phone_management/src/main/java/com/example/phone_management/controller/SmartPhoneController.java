package com.example.phone_management.controller;

import com.example.phone_management.model.SmartPhone;
import com.example.phone_management.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/smartPhones")
public class SmartPhoneController {
  @Autowired
  private ISmartPhoneService<SmartPhone> iSmartPhoneService;

  @PostMapping
  public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone) {
    return new ResponseEntity<>(iSmartPhoneService.save(smartPhone), HttpStatus.ACCEPTED);
  }


}
