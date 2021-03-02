package com.pratiksha.demo.controller;

import com.pratiksha.demo.entity.BankEmployeeLogInfo;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.service.EmployeeServiceLogInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

   private final  EmployeeServiceLogInfo service;

    @PatchMapping("/employee")
    public ResponseEntity<Response> updatePassword(@RequestHeader("userName") String userName,
                                                   @RequestBody BankEmployeeLogInfo info) {
        log.info("Entering in class:LoginController  Method: updatePassword");

        return new ResponseEntity<>(service.updatePassword(userName,info), HttpStatus.OK);

    }
}
