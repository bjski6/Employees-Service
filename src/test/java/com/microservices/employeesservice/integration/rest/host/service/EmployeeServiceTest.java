package com.microservices.employeesservice.integration.rest.host.service;

import com.microservices.employeesservice.integration.rest.host.common.ProduceSampleData;
import com.microservices.employeesservice.integration.rest.host.dto.EmployeeDto;
import com.microservices.employeesservice.model.Employee;
import com.microservices.employeesservice.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    void cleanUp(){
        employeeRepository.deleteAll();
    }

    @Test
    void shouldReturnEmployeeForGivenEmployeeId(){
        //given
        Employee employee1 = ProduceSampleData.createSampleEmployee("1");
        Employee employee2 = ProduceSampleData.createSampleEmployee("2");
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        //when
        Optional<EmployeeDto> employeeDetails = employeeService.getEmployeeDetails("1");

        //then
        assertThat(employeeDetails).isPresent();
    }

    @Test
    void shouldReturnEmptyOptionalWhenEmployeeNotFound(){
        //given
        Employee employee1 = ProduceSampleData.createSampleEmployee("1");
        employeeRepository.save(employee1);

        //when
        Optional<EmployeeDto> employeeDetails = employeeService.getEmployeeDetails("2");

        //then
        assertThat(employeeDetails).isNotPresent();

    }

}