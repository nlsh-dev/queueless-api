package com.queueless.Queueless.token_module.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueTokenCreateRequest {

    @NotNull(message = "Queue ID is required")
    private Long queueId;

    @NotNull(message = "User ID is required")
    private Long userId;

    private Long appointmentId;

    @NotNull(message = "Token number is required")
    @Positive(message = "Token number must be greater than 0")
    private Integer tokenNumber;
}