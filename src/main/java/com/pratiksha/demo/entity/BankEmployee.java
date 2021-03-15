package com.pratiksha.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bankEmployee")
public class BankEmployee {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotBlank(message = "EmployeeName is mandatory")
    private String employeeName;
    @NotBlank(message = "E-mail ID is Mandatory")
    private String emailId;
    @NotBlank(message = "Adhar Number is mandatory")
    private String adharNumber;
    @NotBlank(message = "PAN Number is mandatory")
    private String panNumber;
    @NotBlank(message = "Please mention Bank Name ")
    private String bankName;
    @NotBlank(message = "IFSC Code is mandatory")
    private String ifscCode;
    private Integer otp;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "foreignKey")
    private BankEmployeeLogInfo bankEmployeeLogInfo;

}
