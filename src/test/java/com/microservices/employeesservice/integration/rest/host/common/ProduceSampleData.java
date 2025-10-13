package com.microservices.employeesservice.integration.rest.host.common;

import com.microservices.employeesservice.model.Employee;
import com.microservices.employeesservice.model.Role;

import java.time.LocalDate;

public class ProduceSampleData {

    public static Employee createSampleEmployee(){
        return Employee.builder()
                .employeeId("1")
                .name("name")
                .surname("surname")
                .role(Role.UNKNOWN)
                .hiringDate(LocalDate.now())
                .build();
    }

    public static Employee createSampleEmployee(String employeeId){
        return Employee.builder()
                .employeeId(employeeId)
                .name("name")
                .surname("surname")
                .role(Role.UNKNOWN)
                .hiringDate(LocalDate.now())
                .build();
    }
}
