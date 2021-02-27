package com.pratiksha.demo.repository;

import com.pratiksha.demo.entity.BankEmployeeLogInfo;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BankEmployeeLogInfoRepo extends JpaRepository<BankEmployeeLogInfo,Long> {
    BankEmployeeLogInfo findByUserName(String userName);
}
