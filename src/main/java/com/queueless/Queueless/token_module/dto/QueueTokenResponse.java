package com.queueless.Queueless.token_module.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueTokenResponse {

    private Long id;

    private Long queueId;

    private Long userId;

    private Long appointmentId;

    private Integer tokenNumber;

    private String status;

    private LocalDateTime joinedAt;

    private LocalDateTime calledAt;

    private LocalDateTime serviceStartedAt;

    private LocalDateTime completedAt;

    private LocalDateTime cancelledAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}