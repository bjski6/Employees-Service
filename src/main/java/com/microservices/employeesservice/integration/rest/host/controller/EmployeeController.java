package com.microservices.employeesservice.integration.rest.host.controller;

import com.microservices.employeesservice.integration.rest.host.config.RestEndpoints;
import com.microservices.employeesservice.integration.rest.host.dto.EmployeeDto;
import com.microservices.employeesservice.integration.rest.host.dto.Response;
import com.microservices.employeesservice.integration.rest.host.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Rest controller to provide API for integration.
 * Allow Http methods to expose data transfer objects from service layer.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(RestEndpoints.EMPLOYEES)
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    @ResponseBody
    @Operation(description = "Endpoint returning a body containing employee data for given employee id.")
    public ResponseEntity<?> getEmployeeDetails(@PathVariable("employeeId") String employeeId) {
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeDetails(employeeId);

        return employeeDto.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(employeeDto)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Employee not found.", HttpStatus.NOT_FOUND.value()));
    }

}
