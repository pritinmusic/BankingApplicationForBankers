package com.pratiksha.demo.controller;

import com.pratiksha.demo.entity.BankEmployee;
import com.pratiksha.demo.entity.BankEmployeeLogInfo;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.service.EmployeeServiceLogInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/confirm")
    public ResponseEntity<Response> activateUser(@RequestParam("token") String token)
    {
        log.info("Entering in class :LoginController  Method:updateUserLink");
        return new ResponseEntity<>(service.activateUser(token),HttpStatus.OK);

    }
    @PatchMapping("/activateLink")
            public ResponseEntity<Response> activateLink(@RequestBody BankEmployee bankEmployee)
    {
        return new ResponseEntity<>(service.activateLink(bankEmployee),HttpStatus.OK);
    }
    @PatchMapping("/forgetPassword")
    public ResponseEntity<Response> sendingOTP(@RequestBody BankEmployee bankEmployee)
    {
        return new ResponseEntity<>(service.sendingOTP(bankEmployee),HttpStatus.OK);
    }
    @PatchMapping("/resetPassword")
    public ResponseEntity<Response> resetPassword(@RequestBody BankEmployee bankEmployee)
    {
        return new ResponseEntity<>(service.resetPassword(bankEmployee),HttpStatus.OK);

    }
}

