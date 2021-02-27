package com.pratiksha.demo.controller;

import com.pratiksha.demo.entity.BankEmployee;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;


    @PostMapping("/employee")
    public ResponseEntity<Response> saveEmployee(@RequestBody BankEmployee employee)
    {
        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

   @GetMapping("/employee/{id}")
   public ResponseEntity<BankEmployee> getEmployee(@PathVariable("id") Long id)
   {
       return new ResponseEntity(service.getEmployee(id),HttpStatus.OK);

   }
   @DeleteMapping("/employee/{id}")
    public ResponseEntity<BankEmployee> deleteById(@PathVariable("id") Long id)
   {
       return new ResponseEntity(service.deleteById(id),HttpStatus.OK);
   }

}
