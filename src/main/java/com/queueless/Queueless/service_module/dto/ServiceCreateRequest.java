package com.queueless.Queueless.service_module.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceCreateRequest {

    @NotBlank(message = "Service name is required")
    @Size(max = 150, message = "Service name must not exceed 150 characters")
    private String name;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @Min(value = 1, message = "Average duration must be greater than 0")
    private Integer averageDurationMinutes;
}