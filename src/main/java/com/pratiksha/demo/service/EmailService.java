package com.pratiksha.demo.service;

import com.pratiksha.demo.entity.BankEmployee;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.utility.CommonProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@Data
@RequiredArgsConstructor
public class EmailService {

    public final JavaMailSender mailSender;

    public Response sendingEmail(BankEmployee  bankEmployee) {
        log.info("Entering in EmployeeEmailSendingClass Method : SendingEmail");
        String appUrl = "http://localhost:8080";
        Response response=new Response();
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(bankEmployee.getEmailId());
        mailMessage.setSubject(CommonProperties.USER_SUBJECT);
        mailMessage.setText("To confirm your Account, please click the link below:\n" + appUrl+
               "/confirm?token=" + bankEmployee.getBankEmployeeLogInfo().getToken());
        mailSender.send(mailMessage);
        response.setType(CommonProperties.SUCCESS_TYPE);
        response.setMessage(CommonProperties.USER_ACTIVATION_MAIL);
        log.info("Ending the EmployeeEmailSendingClass Method : SendingEmail");
        return response;
    }


    public Response sendingOTP(BankEmployee  bankEmployee) {
        log.info("Entering in EmployeeEmailSendingClass Method : SendingEmail");
        Response response=new Response();
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(bankEmployee.getEmailId());
        mailMessage.setSubject(CommonProperties.USER_SUBJECT);
        mailMessage.setText("To use given otp for resetting the password , please find below:\n"
               +"otp : " + bankEmployee.getOtp());
        mailSender.send(mailMessage);
        response.setType(CommonProperties.SUCCESS_TYPE);
        response.setMessage(CommonProperties.USER_ACTIVATION_MAIL);
        log.info("Ending the EmployeeEmailSendingClass Method : SendingEmail");
        return response;
    }


}
