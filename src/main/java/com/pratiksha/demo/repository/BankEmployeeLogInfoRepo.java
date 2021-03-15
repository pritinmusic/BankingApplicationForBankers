package com.pratiksha.demo.repository;

import com.pratiksha.demo.entity.BankEmployee;
import com.pratiksha.demo.entity.BankEmployeeLogInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BankEmployeeLogInfoRepo extends JpaRepository<BankEmployeeLogInfo,Integer> {

    BankEmployeeLogInfo findByUserName(String userName);

   Optional<BankEmployeeLogInfo> findByToken(String token);


}
