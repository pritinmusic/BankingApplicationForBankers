package com.pratiksha.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Validated
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotBlank
    private Long customerId;
  //  @NotBlank
    private String email;
    //@NotBlank
    @Column(name = "customerMobileNumber",length =10)
    private Long customerMobileNumber;
    //@NotBlank
    private String address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "foreignKey")
    private Account account;

}


