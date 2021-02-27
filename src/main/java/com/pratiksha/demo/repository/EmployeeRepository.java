package com.pratiksha.demo.repository;

import com.pratiksha.demo.entity.BankEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<BankEmployee,Long> {



}
