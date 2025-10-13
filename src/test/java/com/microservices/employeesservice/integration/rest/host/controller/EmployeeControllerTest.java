package com.microservices.employeesservice.integration.rest.host.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.employeesservice.integration.rest.host.common.ProduceSampleData;
import com.microservices.employeesservice.integration.rest.host.config.RestEndpoints;
import com.microservices.employeesservice.integration.rest.host.dto.EmployeeDto;
import com.microservices.employeesservice.integration.rest.host.dto.Response;
import com.microservices.employeesservice.integration.rest.host.mapper.EmployeeMapper;
import com.microservices.employeesservice.integration.rest.host.service.EmployeeService;
import com.microservices.employeesservice.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private EmployeeService employeeService;
    @MockitoBean
    private EmployeeRepository employeeRepository;

    @Test
    void shouldReturnEmployeeDetailsOnSuccessResponse() throws Exception {
        //given
        String employeeId = "1";
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToDto(ProduceSampleData.createSampleEmployee(employeeId));
        Mockito.when(employeeService.getEmployeeDetails(employeeId)).thenReturn(Optional.of(employeeDto));

        //then
        mockMvc.perform(MockMvcRequestBuilders.get(RestEndpoints.EMPLOYEES + "/{employeeId}", employeeId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(employeeDto)));
    }

    @Test
    void shouldReturnNotFoundWhenEmployeeNotExists() throws Exception {
        //given
        String employeeId = "1";
        Response response = new Response("Employee not found.", HttpStatus.NOT_FOUND.value());
        Mockito.when(employeeService.getEmployeeDetails(employeeId)).thenReturn(Optional.empty());

        //then
        mockMvc.perform(MockMvcRequestBuilders.get(RestEndpoints.EMPLOYEES + "/{employeeId}", employeeId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(response)));
    }
}