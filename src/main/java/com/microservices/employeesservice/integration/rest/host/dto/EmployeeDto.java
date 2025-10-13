package com.microservices.employeesservice.integration.rest.host.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.employeesservice.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {

    @NotNull
    @JsonProperty(required = true)
    @Schema(description = "Unique identifier of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
    private String employeeId;
    @NotNull
    @JsonProperty(required = true)
    @Schema(description = "First name of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @NotNull
    @JsonProperty(required = true)
    @Schema(description = "Last name of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
    private String surname;
    @Schema(description = "Role/position of the employee", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Role role;
    @NotNull
    @JsonProperty(required = true)
    @Schema(description = "Date of hiring the employee", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate hiringDate;

}
