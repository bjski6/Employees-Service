package com.microservices.employeesservice.integration.rest.host.service;

import com.microservices.employeesservice.integration.rest.host.dto.EmployeeDto;
import com.microservices.employeesservice.integration.rest.host.mapper.EmployeeMapper;
import com.microservices.employeesservice.model.Employee;
import com.microservices.employeesservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Optional<EmployeeDto> getEmployeeDetails(String employeeId) {
        return employeeRepository.findEmployeeByEmployeeId(employeeId)
                .map(this::mapEmploeeToEmployeeDto);
    }


    private EmployeeDto mapEmploeeToEmployeeDto(Employee employee) {
        return EmployeeMapper.INSTANCE.mapToDto(employee);
    }
}
