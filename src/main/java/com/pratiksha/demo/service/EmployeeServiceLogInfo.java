package com.pratiksha.demo.service;

import com.pratiksha.demo.entity.BankEmployee;
import com.pratiksha.demo.entity.BankEmployeeLogInfo;
import com.pratiksha.demo.exception.ApiException;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.repository.BankEmployeeLogInfoRepo;
import com.pratiksha.demo.repository.EmployeeRepository;
import com.pratiksha.demo.utility.CommonProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceLogInfo {
    private final BankEmployeeLogInfoRepo repo;
    private final EmployeeRepository employeeRepositoryRepo;
    private final EmailService emailService;


    public Response updatePassword(String userName, BankEmployeeLogInfo info) {
        Response response = new Response();
        ;
        BankEmployeeLogInfo bankEmployeeLogInfo = repo.findByUserName(userName);
        bankEmployeeLogInfo.setPassword(info.getPassword());
        BankEmployeeLogInfo createBankEmployeeInfo = repo.save(bankEmployeeLogInfo);
        if (createBankEmployeeInfo != null) {
            response.setType(CommonProperties.SUCCESS_TYPE);
            response.setMessage(CommonProperties.SUCCESS_UPDATE_MESSAGE);
        } else {
            response.setType(CommonProperties.ERROR_TYPE);
            response.setMessage(CommonProperties.PROBLEM_ERROR);
        }
        return response;

    }


    public Response activateUser(String token) {
        log.info("Entering in class: EmployeeServiceLogInfo Method: activeUser");
        Response response = new Response();
        BankEmployeeLogInfo bankEmployeeLogInfo = repo.findByToken(token).orElseThrow(() -> new ApiException(CommonProperties.NO_DATA_FOUND));
        bankEmployeeLogInfo.setIsActive(true);
        repo.save(bankEmployeeLogInfo);
        response.setType(CommonProperties.SUCCESS_TYPE);
        response.setMessage(CommonProperties.USER_ACTIVATE);
        log.info("Ending class EmployeeServiceLogInfo Method: activeUser");
        return response;

    }

    public Response activateLink(BankEmployee bankEmployee) {
        BankEmployee bankEmployeeFound = employeeRepositoryRepo.findByEmailId(bankEmployee.getEmailId()).orElseThrow(() -> new ApiException(CommonProperties.NO_DATA_FOUND));
        bankEmployeeFound.getBankEmployeeLogInfo().setIsActive(false);
        bankEmployeeFound.getBankEmployeeLogInfo().setToken(String.valueOf(UUID.randomUUID()));
        employeeRepositoryRepo.save(bankEmployeeFound);
        emailService.sendingEmail(bankEmployeeFound);
        Response response = new Response();
        response.setType(CommonProperties.SUCCESS_TYPE);
        response.setMessage(CommonProperties.USER_ACTIVATION_MAIL);
        return response;
    }


    public Response sendingOTP(BankEmployee bankEmployee) {

        BankEmployee bankEmployeeFound = employeeRepositoryRepo.findByEmailId(bankEmployee.getEmailId()).orElseThrow(() -> new ApiException());
        Integer otp = new Random().nextInt(10000);
        log.info("The OTP is" + otp);
        bankEmployeeFound.setOtp(otp);
        bankEmployeeFound.getBankEmployeeLogInfo().setIsActive(false);
        employeeRepositoryRepo.save(bankEmployeeFound);
        emailService.sendingOTP(bankEmployeeFound);
        Response response=new Response();
        response.setType(CommonProperties.SUCCESS_TYPE);
        response.setMessage(CommonProperties.USER_OTP);
        return response;
        //OTP  Sent!!
    }


    public Response resetPassword(BankEmployee bankEmployee) {
        Response response =new Response();
        BankEmployee employeeFound=employeeRepositoryRepo.findByOtp(bankEmployee.getOtp()).orElseThrow(() -> new ApiException("User not found!!"));
        employeeFound.getBankEmployeeLogInfo().setIsActive(true);
        employeeFound.setOtp(null);
        employeeFound.getBankEmployeeLogInfo().setPassword(bankEmployee.getBankEmployeeLogInfo().getPassword());
        employeeRepositoryRepo.save(employeeFound) ;
        response.setType(CommonProperties.SUCCESS_TYPE);
        response.setMessage(CommonProperties.PASSWORD_RESET);
        return response;
    }


    //save
    //findById
    //findAll
    //delete
    //deleteById

}
