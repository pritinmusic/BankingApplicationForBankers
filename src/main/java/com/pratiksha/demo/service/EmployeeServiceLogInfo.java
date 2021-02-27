package com.pratiksha.demo.service;

import com.pratiksha.demo.entity.BankEmployeeLogInfo;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.repository.BankEmployeeLogInfoRepo;
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
            response.setType("Success");
            response.setMessage("Employee Information updated Successfully");
        }
        else{
            response.setType("Error");
            response.setMessage("Some Problem happen!!");
        }
        return response;

    }



    //save
    //findById
    //findAll
    //delete
    //deleteById

}
