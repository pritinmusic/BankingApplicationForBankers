package com.pratiksha.demo.model;

import com.pratiksha.demo.entity.BankEmployee;
import com.pratiksha.demo.entity.BankEmployeeLogInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String type;
    private BankEmployee employee;
  //  private BankEmployeeLogInfo logInfo;
    private String message;

}
