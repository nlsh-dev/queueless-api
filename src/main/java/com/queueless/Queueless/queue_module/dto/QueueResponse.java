package com.queueless.Queueless.queue_module.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueResponse {

    private Long id;

    private Long serviceId;

    private LocalDate queueDate;

    private String status;

    private Integer nextTokenNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}