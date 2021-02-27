package com.pratiksha.demo.service;

import com.pratiksha.demo.entity.BankEmployeeLogInfo;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.repository.BankEmployeeLogInfoRepo;
import com.pratiksha.demo.utility.CommonProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceLogInfo {
    private final BankEmployeeLogInfoRepo repo;


    public Response updatePassword(String userName, BankEmployeeLogInfo info) {
        Response response=new Response();;
        BankEmployeeLogInfo bankEmployeeLogInfo = repo.findByUserName(userName);
        bankEmployeeLogInfo.setPassword(info.getPassword());
        BankEmployeeLogInfo createBankEmployeeInfo= repo.save(bankEmployeeLogInfo);
        if(createBankEmployeeInfo!=null){
            response.setType(CommonProperties.SUCCESS_TYPE);
            response.setMessage( CommonProperties.SUCCESS_UPDATE_MESSAGE);          ;
        }
        else{
            response.setType(CommonProperties.ERROR_TYPE);
            response.setMessage(CommonProperties.PROBLEM_ERROR);
        }
        return response;

    }



    //save
    //findById
    //findAll
    //delete
    //deleteById

}
