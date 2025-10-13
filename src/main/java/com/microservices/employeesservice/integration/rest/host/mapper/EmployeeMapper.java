package com.microservices.employeesservice.integration.rest.host.mapper;

import com.microservices.employeesservice.integration.rest.host.dto.EmployeeDto;
import com.microservices.employeesservice.model.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee mapToModel(EmployeeDto employeeDto);

    @InheritInverseConfiguration(name = "mapToModel")
    EmployeeDto mapToDto(Employee employee);
}
