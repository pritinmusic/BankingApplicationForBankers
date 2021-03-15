package com.pratiksha.demo.controller;

import com.pratiksha.demo.entity.Account;
import com.pratiksha.demo.entity.Customer;
import com.pratiksha.demo.service.CostomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class CostomerController {
  private final CostomerService service;

    @PostMapping("/createAccount")
    public ResponseEntity createAccount(@RequestBody Customer customer)
    {
        return new ResponseEntity(service.createAccount(customer), HttpStatus.OK);
    }
}
