package com.pratiksha.demo.service;

import com.pratiksha.demo.entity.BankEmployee;
import com.pratiksha.demo.exception.ApiException;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.repository.EmployeeRepository;
import com.pratiksha.demo.utility.CommonProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repo;

    public Response saveEmployee(BankEmployee employee) {
        log.info("inside class name:EmployeeService method:saveEmployee started");
        Response response = new Response();
        employee.getBankEmployeeLogInfo().setIsActive(false);
        BankEmployee bankEmployee = repo.save(employee);
        if (bankEmployee == null) {
            throw new ApiException(CommonProperties.PROBLEM_ERROR);
        }
        response.setType(CommonProperties.SUCCESS_TYPE);
        response.setMessage(CommonProperties.SUCCESS_SAVE_MESSAGE);
        log.info("inside class name:EmployeeService method:saveEmployee ended");
        return response;
    }

    public Response getEmployee(Long id) {
     log.info("inside class: EmployeeService method: getEmployee");
        BankEmployee bankEmployee = repo.findById(id).orElseThrow(()->new ApiException(CommonProperties.NO_DATA_FOUND)); // Or use get();
        Response response = new Response();
        response.setType(CommonProperties.SUCCESS_TYPE);
        response.setEmployee(bankEmployee);
        log.info("inside class: EmployeeService method: getEmployee ended ");
        return response;
    }

    public Response deleteById(Long id) {
        log.info("inside class: EmployeeService method: deleteById");
        Response response = null;
        BankEmployee bankEmployee = repo.findById(id).orElseThrow(()->new ApiException(CommonProperties.NO_DATA_FOUND)); // Or use get();
        repo.delete(bankEmployee);
        if(bankEmployee != null) {
            response = new Response();
            response.setType(CommonProperties.SUCCESS_TYPE);
            response.setMessage(CommonProperties.SUCCESS_DELETE_MESSAGE);
        }
        log.info("inside class: EmployeeService method: getEmployee Ended");
        return response;
    }
}
