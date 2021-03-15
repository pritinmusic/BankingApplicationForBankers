package com.pratiksha.demo.service;

import com.pratiksha.demo.entity.Account;
import com.pratiksha.demo.entity.Customer;
import com.pratiksha.demo.exception.ApiException;
import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.repository.CustomerRepo;
import com.pratiksha.demo.utility.CommonProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Service
public class CostomerService {
    private final CustomerRepo customerRepo;

    public Response createAccount(Customer customer) {
        log.info("Entering in to createAccount method");
        Response response = new Response();
        customer.setCustomerId(Long.valueOf(new Random().nextInt(10000000)));
        // Customer customerFound=customer.getAccount().getAccountType().toString().;
        if (!customer.getAccount().getAccountType().equalsIgnoreCase("SAVING") && !customer.getAccount().getAccountType().equalsIgnoreCase("CURRENT")) {
            throw new ApiException(CommonProperties.PROBLEM_ERROR);
        }

        if (customer.getAccount().getInitialAmount() < 10000 && customer.getAccount().getAccountType().equalsIgnoreCase("Saving")) {
            throw new ApiException(CommonProperties.PROBLEM_ERROR);
        }

        customerRepo.save(customer);
        response.setMessage(CommonProperties.ACCOUNT_CREATED);
        response.setType(CommonProperties.SUCCESS_TYPE);
        log.info("Exiting into createAccount method");
        return response;

    }
}
