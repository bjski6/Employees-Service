package com.microservices.employeesservice.integration.rest.host.mapper;

import com.microservices.employeesservice.integration.rest.host.common.ProduceSampleData;
import com.microservices.employeesservice.integration.rest.host.dto.EmployeeDto;
import com.microservices.employeesservice.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    @Test
    void shouldMapEmployeeToEmployeeDto(){
        //given
        Employee employee = ProduceSampleData.createSampleEmployee();

        //when
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToDto(employee);

        //then
        assertNotNull(employeeDto);
        assertEquals(employeeDto.getEmployeeId(), employee.getEmployeeId());
        assertEquals(employeeDto.getName(), employee.getName());
        assertEquals(employeeDto.getSurname(), employee.getSurname());
        assertEquals(employeeDto.getRole(), employee.getRole());
        assertEquals(employeeDto.getHiringDate(), employee.getHiringDate());
    }

}