package com.pratiksha.demo.service;

import com.pratiksha.demo.entity.BankEmployee;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.repository.EmployeeRepository;
import com.pratiksha.demo.utility.CommonProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repo;

    public Response saveEmployee(BankEmployee employee) {
        Response response=new Response();
        employee.getBankEmployeeLogInfo().setIsActive(false);
        BankEmployee bankEmployee= repo.save(employee);
        if(bankEmployee!=null)
        {
            response.setType(CommonProperties.SUCCESS_TYPE);
            response.setMessage(CommonProperties.SUCCESS_SAVE_MESSAGE);
        }
        else
        {
            response.setType(CommonProperties.ERROR_TYPE);
            response.setMessage(CommonProperties.PROBLEM_ERROR);
        }
        return response;
    }


    public Response getEmployee(Long id) {
        Response response = null;
        BankEmployee bankEmployee = repo.findById(id).orElse(null); // Or use get();

        if (bankEmployee == null) {
            response = new Response();
            response.setType(CommonProperties.ERROR_TYPE);
            response.setMessage(CommonProperties.NO_DATA_FOUND);
        } else {
            response = new Response();
            response.setType(CommonProperties.SUCCESS_TYPE);
            response.setEmployee(bankEmployee);
        }


        return response;
    }

    public Response deleteById(Long id) {
        Response response = null;
        BankEmployee bankEmployee = repo.findById(id).orElse(null);
        if(null!=bankEmployee)
         repo.delete(bankEmployee);
        if(bankEmployee != null) {
            response = new Response();
            response.setType(CommonProperties.SUCCESS_TYPE);
            response.setMessage(CommonProperties.SUCCESS_DELETE_MESSAGE);
        } else {
            response = new Response();
            response.setType(CommonProperties.ERROR_TYPE);
            response.setMessage(CommonProperties.NO_DATA_FOUND);
        }
        return response;
    }
}
