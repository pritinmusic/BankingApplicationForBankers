package com.pratiksha.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bankEmployee")
public class BankEmployee {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String emailId;
    private String  adharNumber;
    private String  panNumber;
    private String  bankName;
    private String ifscCode;

    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="foreignKey")
    private BankEmployeeLogInfo bankEmployeeLogInfo;

}
