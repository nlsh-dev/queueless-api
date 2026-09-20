package com.queueless.Queueless.queue_module.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueCreateRequest {

    @NotNull(message = "Service ID is required")
    private Long serviceId;

    @NotNull(message = "Queue date is required")
    private LocalDate queueDate;
}