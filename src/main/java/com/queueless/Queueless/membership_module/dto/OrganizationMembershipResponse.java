package com.queueless.Queueless.membership_module.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationMembershipResponse {

    private Long id;

    private Long userId;

    private Long organizationId;

    private String role;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}