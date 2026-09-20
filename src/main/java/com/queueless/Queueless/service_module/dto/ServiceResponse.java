package com.queueless.Queueless.service_module.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceResponse {

    private Long id;

    private String name;

    private String description;

    private Integer averageDurationMinutes;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}