package com.pratiksha.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bankEmployeeLogInfo")
public class BankEmployeeLogInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isActive;
    @NotBlank(message = "Please give UserName")
    private String userName;
    @NotBlank(message = "Please give Password")
    private String password;


}
